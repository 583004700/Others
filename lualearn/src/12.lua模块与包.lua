--[[Lua
模块与包
模块类似于一个封装库，从
Lua
5.1
开始，Lua
加入了标准的模块管理机制，可以把一些公用的代码放在一个文件里，以
API
接口的形式在其他地方调用，有利于代码的重用和降低代码耦合度。

Lua
的模块是由变量、函数等已知元素组成的
table，因此创建一个模块很简单，就是创建一个
table，然后把需要导出的常量、函数放入其中，最后返回这个
table
就行。以下为创建自定义模块
module.lua，文件代码格式如下：]]
--[[由上可知，模块的结构就是一个 table 的结构，因此可以像操作调用 table 里的元素那样来操作调用模块里的常量或函数。

上面的 func2 声明为程序块的局部变量，即表示一个私有函数，因此是不能从外部访问模块里的这个私有函数，必须通过模块里的公有函数来调用.]]

--[[    require 函数
    Lua提供了一个名为require的函数用来加载模块。要加载一个模块，只需要简单地调用就可以了。例如：

    require("<模块名>")
    或者

    require "<模块名>"
    执行 require 后会返回一个由模块常量或函数组成的 table，并且还会定义一个包含该 table 的全局变量。]]

-- test_module.php 文件
-- module 模块为上文提到到 module.lua
require("module")

print(module.constant)

module.func3()

--或者给加载的模块定义一个别名变量，方便调用：

-- test_module2.php 文件
-- module 模块为上文提到到 module.lua
-- 别名变量 m
local m = require("module")

print(m.constant)

m.func3()

--[[
加载机制
对于自定义的模块，模块文件不是放在哪个文件目录都行，函数
require
有它自己的文件路径加载策略，它会尝试从
Lua
文件或
C
程序库中加载模块。

require
用于搜索
Lua
文件的路径是存放在全局变量
package.path
中，当
Lua
启动后，会以环境变量
LUA_PATH
的值来初始这个环境变量。如果没有找到该环境变量，则使用一个编译时定义的默认路径来初始化。

当然，如果没有
LUA_PATH
这个环境变量，也可以自定义设置，在当前用户根目录下打开 .profile
文件（没有则创建，打开 .bashrc
文件也可以），例如把 "~/lua/"
路径加入
LUA_PATH
环境变量里：

#LUA_PATH
export
LUA_PATH = "~/lua/?.lua;;"
文件路径以 ";"
号分隔，最后的
2
个 ";;"
表示新加的路径后面加上原来的默认路径。

接着，更新环境变量参数，使之立即生效。

source ~/.profile
这时假设 package.path 的值是：

/Users/dengjoe/lua/?.lua;./?.lua;/usr/ local /share/lua/5.1/?.lua;/usr/ local /share/lua/5.1/?/init.lua;/usr/ local/lib/lua/5.1/?.lua;/usr/ local /lib/lua/5.1/?/init.lua
那么调用 require("module") 时就会尝试打开以下文件目录去搜索目标。

/Users/dengjoe/lua/module.lua;
./module.lua
/usr/ local /share/lua/5.1/module.lua
/usr/ local /share/lua/5.1/module/init.lua
/usr/ local /lib/lua/5.1/module.lua
/usr/ local /lib/lua/5.1/module/init.lua
如果找过目标文件，则会调用 package.loadfile 来加载模块。否则，就会去找 C 程序库。

搜索的文件路径是从全局变量 package.cpath 获取，而这个变量则是通过环境变量 LUA_CPATH 来初始。

搜索的策略跟上面的一样，只不过现在换成搜索的是 so 或 dll 类型的文件。如果找得到，那么 require 就会通过 package.loadlib 来加载它。

C 包
Lua和C是很容易结合的，使用C为Lua写包。

与Lua中写包不同，C包在使用以前必须首先加载并连接，在大多数系统中最容易的实现方式是通过动态连接库机制。

Lua在一个叫loadlib的函数内提供了所有的动态连接的功能。这个函数有两个参数:库的绝对路径和初始化函数。所以典型的调用的例子如下:

local path = "/usr/local/lua/lib/libluasocket.so"
local f = loadlib(path, "luaopen_socket")
loadlib函数加载指定的库并且连接到Lua，然而它并不打开库（也就是说没有调用初始化函数），反之他返回初始化函数作为Lua的一个函数，这样我们就可以直接在Lua中调用他。

如果加载动态库或者查找初始化函数时出错，loadlib将返回nil和错误信息。我们可以修改前面一段代码，使其检测错误然后调用初始化函数：

local path = "/usr/local/lua/lib/libluasocket.so"
-- 或者 path = "C:\\windows\\luasocket.dll"，这是 Window 平台下
local f = assert(loadlib(path, "luaopen_socket"))
f()  -- 真正打开库
一般情况下我们期望二进制的发布库包含一个与前面代码段相似的stub文件，安装二进制库的时候可以随便放在某个目录，只需要修改stub文件对应二进制库的实际路径即可。

将stub文件所在的目录加入到LUA_PATH，这样设定后就可以使用require函数加载C库了。]]

print(package.path)