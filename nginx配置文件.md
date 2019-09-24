### 配置文件

配置文件主要由四部分组成：

 - main(全区设置)
 - server(主机配置)
 - http(控制着nginx http处理的所有核心特性)

     - location(URL匹配特定位置设置)。
 - upstream(负载均衡服务器设置)



```
#Nginx的worker进程运行用户以及用户组
#user  nobody;

#Nginx开启的进程数
worker_processes  1;

#定义全局错误日志定义类型，[debug|info|notice|warn|crit]
#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;

#指定进程ID存储文件位置
#pid        logs/nginx.pid;


#事件配置
events {

    #use [ kqueue | rtsig | epoll | /dev/poll | select | poll ];
    #epoll模型是Linux内核中的高性能网络I/O模型，如果在mac上面，就用kqueue模型。
    use kqueue;

    #每个进程可以处理的最大连接数，理论上每台nginx服务器的最大连接数为	    worker_processes*worker_connections。
    
    理论值：worker_rlimit_nofile/worker_processes
    worker_connections  1024;
}

#http参数
http {
    #文件扩展名与文件类型映射表
    include       mime.types;
    #默认文件类型
    default_type  application/octet-stream;

    #日志相关定义
    #log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
    #                  '$status $body_bytes_sent "$http_referer" '
    #                  '"$http_user_agent" "$http_x_forwarded_for"';

    #连接日志的路径，指定的日志格式放在最后。
    #access_log  logs/access.log  main;

    #开启高效传输模式
    sendfile        on;

    #防止网络阻塞
    #tcp_nopush     on;

    #客户端连接超时时间，单位是秒
    #keepalive_timeout  0;
    keepalive_timeout  65;

    #开启gzip压缩输出
    #gzip  on;

    #虚拟主机基本设置
    server {
        #监听的端口号
        listen       80;
        #访问域名
        server_name  localhost;

        #编码格式，如果网页格式与当前配置的不同的话将会被自动转码
        #charset koi8-r;

        #虚拟主机访问日志定义
        #access_log  logs/host.access.log  main;

        #对URL进行匹配
        location / {
            #访问路径，可相对也可绝对路径
            root   html;
            #首页文件，匹配顺序按照配置顺序匹配
            index  index.html index.htm;
        }

        #错误信息返回页面
        #error_page  404              /404.html;

        # redirect server error pages to the static page /50x.html
        #
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }

        #访问URL以.php结尾则自动转交给127.0.0.1
        # proxy the PHP scripts to Apache listening on 127.0.0.1:80
        #
        #location ~ \.php$ {
        #    proxy_pass   http://127.0.0.1;
        #}

        #php脚本请求全部转发给FastCGI处理
        # pass the PHP scripts to FastCGI server listening on 127.0.0.1:9000
        #
        #location ~ \.php$ {
        #    root           html;
        #    fastcgi_pass   127.0.0.1:9000;
        #    fastcgi_index  index.php;
        #    fastcgi_param  SCRIPT_FILENAME  /scripts$fastcgi_script_name;
        #    include        fastcgi_params;
        #}

        #禁止访问.ht页面
        # deny access to .htaccess files, if Apache's document root
        # concurs with nginx's one
        #
        #location ~ /\.ht {
        #    deny  all;
        #}
    }

    #第二个虚拟主机配置
    # another virtual host using mix of IP-, name-, and port-based configuration
    #
    #server {
    #    listen       8000;
    #    listen       somename:8080;
    #    server_name  somename  alias  another.alias;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}


    #HTTPS虚拟主机定义
    # HTTPS server
    #
    #server {
    #    listen       443 ssl;
    #    server_name  localhost;

    #    ssl_certificate      cert.pem;
    #    ssl_certificate_key  cert.key;

    #    ssl_session_cache    shared:SSL:1m;
    #    ssl_session_timeout  5m;

    #    ssl_ciphers  HIGH:!aNULL:!MD5;
    #    ssl_prefer_server_ciphers  on;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}
    include servers/*;
}
```

### 反向代理实例

假设我现在需要本地访问www.baidu.com;配置如下：

```
server {
    #监听80端口
    listen 80;
    server_name localhost;
     # individual nginx logs for this web vhost
    access_log /tmp/access.log;
    error_log  /tmp/error.log ;

    location / {
        proxy_pass http://www.baidu.com;
    }
```

则把访问localhost变到baidu.com

### 负载均衡实例

下面主要验证最常用的三种负载策略。虚拟主机配置：

```
server {
    #监听80端口
    listen 80;
    server_name localhost;

    # individual nginx logs for this web vhost
    access_log /tmp/access.log;
    error_log  /tmp/error.log ;

    location / {
        #负载均衡
        #轮询 
        #proxy_pass http://polling_strategy;
        #weight权重
        #proxy_pass http://weight_strategy;
        #ip_hash
        # proxy_pass http://ip_hash_strategy;
        #fair
        # proxy_pass http://fair_strategy;
        #url_hash
        # proxy_pass http://url_hash_strategy;
        #重定向
        #rewrite ^ http://localhost:8080;
    }
```

#### 1、轮询

```
# 1、轮询（默认）
# 每个请求按时间顺序逐一分配到不同的后端服务器，如果后端服务器down掉，能自动剔除。 
upstream polling_strategy { 
    server 127.0.0.1:8080; # 应用服务器1
    server 127.0.0.1:8081; # 应用服务器2
} 
```

#### 2、权重

```
#2、指定权重
#指定轮询几率，weight和访问比率成正比，用于后端服务器性能不均的情况。 
upstream  weight_strategy { 
    server glmapper.net:8080 weight=1; # 应用服务器1
    server glmapper.net:8081 weight=9; # 应用服务器2
}
```

#### 3、ip hash策略

```
#3、IP绑定 ip_hash
#每个请求按访问ip的hash结果分配，这样每个访客固定访问一个后端服务器，
#可以解决session的问题;在不考虑引入分布式session的情况下，
#原生HttpSession只对当前servlet容器的上下文环境有效
upstream ip_hash_strategy { 
    ip_hash; 
    server glmapper.net:8080; # 应用服务器1
    server glmapper.net:8081; # 应用服务器2
} 
```

























