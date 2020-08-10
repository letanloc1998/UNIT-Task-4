# TASK4
## PURCHARSE TO PAYMENT ONLINE (P2P ONLINE)
### Hệ thống mua sắm trực tuyến
**Có 3 Role**
1. Admin: quản lý account, category, config system (option).
2. Vendor: quản lý product của mình
3. User: xem và mua hàng của nhiều vendor, quản lí giỏ hàng, thanh toán, lịch sử mua hàng.
## Yêu cầu Developer:
1. 4 bạn dev chung project này, teamwork chia task để kịp deadline 31/8/2020.
2. Tự làm tài liệu thiết kế MH, DB. Thiết kế đơn giản nhưng đủ các thông tin cần thiết.
VD product có: code, name, vendor, giá, số lượng chọn mua, số lượng còn lại trong kho vendor, category, status...
3. Có thể sử dụng bất kỳ Cổng thanh toán các bạn làm đc. 
- Vd Momo: 

  https://developers.momo.vn/#/
  
  https://github.com/momo-wallet/payment
4. Các bạn báo cáo tiến độ t4, t6 trong tuần
5. Sử dụng spring + thymeleaf + MirageSQL

## I. DANH SÁCH CHỨC NĂNG CHÍNH:
1. Admin
- Đăng nhập
- Quản lý Account
  * Chỉnh sửa thông tin
  * Thay đổi mật khẩu 
  * Cập nhật ảnh đại diện
- Quản lý người dùng
  * Thêm người dùng
  * Sửa người dùng
  * Xem người dùng
  * Khóa người dùng
- Quản lý cửa hàng
  * Duyệt thêm cửa hàng
  * Khóa cửa hàng
- Quản lý category
