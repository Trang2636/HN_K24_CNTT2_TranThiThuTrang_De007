
- config-server: 8888
- eureka-server: 8761
- api-gateway: 8080
- brand-service: 8081
- phone-service: 8082

thứ tự chạy
1. Chạy config-server
2. Chạy eureka-server
3. Chạy brand-service
4. Chạy phone-service
5. Chạy api-gateway
   postman
   GET `http://localhost:8080/api/brands/1`
   GET `http://localhost:8080/api/phones`
   POST `http://localhost:8080/api/phones`
{
  "name": "iPhone 17",
  "price": 25000000,
  "brandId": 1
}
thêm với brandId k tồn tại

POST `http://localhost:8080/api/phones`
{
"name": "Phone Test",
"price": 10000000,
"brandId": 999
}

Kết quả là HTTP 400 và điện thoại không được lưu

eureka
Mở `http://localhost:8761`

Các service cần xuất hiện:
- API-GATEWAY
- BRAND-SERVICE
- PHONE-SERVICE
  Client chỉ gọi qua port 8080, không gọi trực tiếp 8081 hoặc 8082
