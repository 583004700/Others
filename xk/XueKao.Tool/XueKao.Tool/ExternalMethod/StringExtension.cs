using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using XueKao.Tool.Helper;

namespace XueKao.Tool.ExternalMethod
{
    /// <summary>
    /// 字符串扩展
    /// </summary>
    public static class StringExtension
    {
        /// <summary>
        /// TryParse委托缓存
        /// </summary>
        private readonly static Dictionary<Type, Delegate> TryParses = new Dictionary<Type, Delegate>();

        /// <summary>
        /// 转换成指定类型
        /// </summary>
        /// <typeparam name="T">目标类型，只支持基础类型</typeparam>
        /// <param name="s">待转换的字符串</param>
        /// <param name="defaultValue">转换失败返回的默认值</param>
        /// <returns>转换成目标类型之后的值</returns>
        public static T As<T>(this string s, T defaultValue)
        {
            if (string.IsNullOrEmpty(s))
                return defaultValue;

            Type type = typeof(T);

            try
            {
                T result;
                if (type.IsEnum)
                {
                    var enumValue = Enum.Parse(type, s, false);
                    result = (T)enumValue;
                    return result;
                }

                TryParse<T> tryParse;
                if (TryParses.ContainsKey(type))
                    tryParse = TryParses[type] as TryParse<T>;
                else
                    tryParse = GetTryParseDelegate<T>();

                if (tryParse == null)
                    return defaultValue;

                if (!tryParse.Invoke(s, out result))
                    return defaultValue;

                if (!TryParses.ContainsKey(type))
                    TryParses.Add(type, tryParse);

                return result;
            }
            catch
            {
                return defaultValue;
            }
        }

        /// <summary>
        /// 根据指定类型获取TryParse的委托
        /// </summary>
        /// <typeparam name="T">类型</typeparam>
        /// <returns>对应类型的TryParse委托，null 表示没有对应的方法</returns>
        public static TryParse<T> GetTryParseDelegate<T>()
        {
            Type type = typeof(T);

            if (!HasTryParseMethod(type))
                return null;

            var method = GetMethods(type, "TryParse", BindingFlags.Public | BindingFlags.Static, new Type[] { typeof(string), typeof(T).MakeByRefType() });
            if (method == null)
                return null;

            Delegate tempDelegate = Delegate.CreateDelegate(typeof(TryParse<T>), method, false);
            if (tempDelegate == null)
                return null;

            return tempDelegate as TryParse<T>;
        }


        /// <summary>
        /// 获取类型中的方法
        /// </summary>
        /// <param name="type">指定类型</param>
        /// <param name="methodName">获取的方法</param>
        /// <param name="bindingFlags">搜索方法的方式</param>
        /// <param name="parameterTypes">方法的参数类型</param>
        /// <returns>
        /// 搜索到的方法对象
        /// <para>搜索不到返回null</para>
        /// </returns>
        public static MethodInfo GetMethods(Type type, string methodName, BindingFlags bindingFlags, Type[] parameterTypes = null)
        {
            if (type == null)
                throw new ArgumentNullException("type");
            if (methodName == null)
                throw new ArgumentNullException("methodName");

            bool hasParameter = parameterTypes != null && parameterTypes.Length > 0;
            var methods = type.GetMethods(bindingFlags);
            foreach (var method in methods)
            {
                if (!method.Name.Equals(methodName))
                    continue;

                var parameters = method.GetParameters();
                bool methodHasParameter = parameters.Length > 0;
                if (!hasParameter && !methodHasParameter)
                    return method;
                if ((hasParameter && !methodHasParameter) || (!hasParameter && methodHasParameter))
                    continue;

                var paramTypes = parameters.Select(paramter => paramter.ParameterType);
                if (paramTypes.Count() != parameterTypes.Count())
                    continue;

                int i = 0;
                foreach (var paramType in paramTypes)
                {
                    if (!(paramType == parameterTypes[i]))
                        break;

                    i++;
                }

                if (i >= paramTypes.Count())
                    return method;
            }

            return null;
        }

        /// <summary>
        /// 是否有定义TryParse方法
        /// </summary>
        /// <param name="type">类型</param>
        /// <returns></returns>
        private static bool HasTryParseMethod(Type type)
        {
            var types = new[] { typeof(int), typeof(uint), typeof(long), typeof(ulong),typeof(short),typeof(ushort)
                                        , typeof(float), typeof(double), typeof(decimal), typeof(DateTime), typeof(byte), typeof(bool)};

            return types.Any(t => t == type);
        }

        /// <summary>
        /// 字符串中是否有Email、HTTP、手机号等特殊字符串，用于校验用户提交的数据是否含有特殊字符串
        /// </summary>
        /// <param name="s"></param>
        /// <returns></returns>
        public static bool HasSpecialWord(this string s)
        {
            const string regForEmail = @"([a-z0-9_\-\.]{1,}@[a-z0-9_\-]{1,}\.[a-z0-9_\-]{1,})";
            const string regForHttp = @"((http[s]?):\/\/[a-z0-9_\-\.]{0,})|(www\.[a-z0-9_\-\.]{0,})";
            const string regForMobile = @"(1[0-9]{10})";
            const string regStr = regForEmail + "|" + regForHttp + "|" + regForMobile;
            return Regex.IsMatch(s, regStr, RegexOptions.IgnoreCase);
        }

        /// <summary>
        /// 替换字符串中的tab(\t)字符，替换成4个空格
        /// </summary>
        /// <param name="s">待替换的字符串</param>
        /// <returns>替换后的字符串</returns>
        public static string ReplaceTabChar(this string s)
        {
            if (string.IsNullOrEmpty(s))
            {
                return s;
            }
            return s.Replace("\t", "    ");
        }

        /// <summary>
        /// 3DES解密
        /// </summary>
        /// <param name="source">原始字符串</param>
        /// <param name="key">解密Key</param>
        /// <returns>解密后的字符串</returns>
        public static string Decrypt3Des(this string source, string key = "")
        {
            if (string.IsNullOrEmpty(key))
            {
                return CryptogramHelper.Decrypt3DES(source);
            }
            return CryptogramHelper.Decrypt3DES(source, key);
        }

        /// <summary>
        /// 3DES加密
        /// </summary>
        /// <param name="source">原始字符串</param>
        /// <param name="key">加密key</param>
        /// <returns>加密后的字符串</returns>
        public static string Encrypt3Des(this string source, string key = "")
        {
            if (string.IsNullOrEmpty(key))
            {
                return CryptogramHelper.Encrypt3DESWithTrueKey(source, key);
            }
            return CryptogramHelper.Encrypt3DESWithTrueKey(source, key);
        }

        /// <summary>
        /// 3DES加密
        /// </summary>
        /// <param name="source">原始字符串</param>
        /// <param name="key">加密key</param>
        /// <returns>加密后的字符串</returns>
        public static string Encrypt3DesWithNet(this string source, string key = "")
        {
            if (string.IsNullOrEmpty(key))
            {
                return CryptogramHelper.Encrypt3DES(source, key);
            }
            return CryptogramHelper.Encrypt3DES(source, key);
        }

        /// <summary>
        /// 转半角的方法
        /// 全角空格为12288，半角空格为32
        /// 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
        /// </summary>
        /// <param name="input"></param>
        /// <returns></returns>
        public static string ToDBC(this string input)
        {
            char[] c = input.ToCharArray();
            for (int i = 0; i < c.Length; i++)
            {
                if (c[i] == 12288)
                {
                    c[i] = (char)32;
                    continue;
                }
                if (c[i] > 65280 && c[i] < 65375)
                    c[i] = (char)(c[i] - 65248);
            }
            return new string(c);
        }
    }

    /// <summary>   
    /// 类型转换委托
    /// </summary>
    /// <typeparam name="T">转换的目标类型，支持基础类型</typeparam>
    /// <param name="s">待转换的字符串</param>
    /// <param name="result">转换结果</param>
    /// <returns></returns>
    public delegate bool TryParse<T>(string s, out T result);
}
