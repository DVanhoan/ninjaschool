# Sử dụng hình ảnh OpenJDK cho ứng dụng Java
FROM openjdk:17-jdk-slim

# Đặt thư mục làm việc
WORKDIR /app

# Sao chép toàn bộ mã nguồn và file JAR
COPY . /app

# Đảm bảo quyền cho thư mục
RUN chmod -R 755 /app

# Thiết lập mã hóa file UTF-8 và tùy chọn JVM
ENV JAVA_OPTS="-server -Dfile.encoding=UTF-8 -Xms1000M -Xmx1000M"

# Expose cổng ứng dụng
EXPOSE 14444

# Lệnh khởi chạy server
CMD ["java", "-cp", "lib/*:dist/NSO-HOIUC.jar", "com.hoiuc.server.NinjaSchool"]
