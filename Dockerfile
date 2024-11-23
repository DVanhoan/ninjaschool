# Sử dụng image MySQL chính thức làm base image
FROM mysql:8.0

# Đặt biến môi trường để tránh lời nhắc mật khẩu root trong khi xây dựng container
ENV MYSQL_ROOT_PASSWORD=1234
ENV MYSQL_DATABASE=nja_account
ENV MYSQL_USER=main
ENV MYSQL_PASSWORD=1234

# Copy file init SQL nếu có
# COPY init.sql /docker-entrypoint-initdb.d/

# Expose cổng mặc định của MySQL
EXPOSE 3306
