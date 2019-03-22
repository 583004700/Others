public class Docker {

    public static void main(String[] args) {
        //cat /etc/redhat-release 查看CentOS版本
        /**
         * centos7下安装docker
         *1.移除旧版本
         *sudo yum remove docker \
         *                   docker-client \
         *                   docker-client-latest \
         *                   docker-common \
         *                   docker-latest \
         *                   docker-latest-logrotate \
         *                   docker-logrotate \
         *                   docker-selinux \
         *                   docker-engine-selinux \
         *                   docker-engine
         * 2.安装一些必要的系统工具
         * sudo yum install -y yum-utils device-mapper-persistent-data lvm2
         * 3.添加软件源信息
         * sudo yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
         * 4.更新yum缓存
         * sudo yum makecache fast
         * 5.安装docker-ce
         * sudo yum -y install docker-ce
         * 6.启动docker后台服务
         * sudo systemctl start docker
         * 7.测试运行hello-world
         * docker run hello-world
         */
    }
}
