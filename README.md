# Docker本地安装Minio：

## 下载镜像：

```shell
docker pull minio/minio:latest
```



## 新建数据挂载目录：

在 `D:` 盘，新建一个 `/docker` 文件夹，然后在该文件夹中再新建一个 `/minio` 文件夹



##  运行 Docker Minio 容器:

```shell
docker run -d \
   -p 9000:9000 \
   -p 9090:9090 \
   --name minio \
   -v E:\docker\minio\data:/data \
   -e "MINIO_ROOT_USER=zsk" \
   -e "MINIO_ROOT_PASSWORD=123456789" \
   minio/minio:latest server /data --console-address ":9090"
```

