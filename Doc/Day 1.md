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
  * Thêm category
  * Sửa category
  * Xóa category
- Login as
- Quản lý Branch
  * Thêm branch
  * Sửa branch
  * Xóa branch
2. Vendor
- Đăng nhập
- Quản lí account
  * Chỉnh sửa thông tin
  * Thay đổi mật khẩu 
  * Cập nhật ảnh đại diện
- Quản lý sản phẩm
  * Thêm sản phẩm
  * Sửa sản phẩm
  * Khóa sản phẩm
- Quản lý cửa hàng
  * Sửa thông tin cửa hàng
  * Khóa cửa hàng
- Quản lí Bill
  * Xem bill
  * Duyệt bill
  * Hủy bill
- Quản lí kho hàng
3. Customer
- Đăng nhập
- Đăng ký
  * Đăng ký tài khoản
  * Đăng kí cửa hàng
- Quản lí Account
  * Chỉnh sửa thông tin
  * Thay đổi mật khẩu 
  * Cập nhật ảnh đại diện
- Quản lý Cart
  * Thêm sản phẩm trong cart.
  * Sửa sản phẩm trong cart.
  * Xóa sản phẩm trong cart.
- Thanh toán:
  * MoMo
  * Paypal
  * Stripe
- Xem lịch sử đơn hàng.

## II. LIST SCREEN
1. Home screen

    https://colorlib.com/preview/theme/onetech/#

    https://colorlib.com/preview/#aroma

2. Login/Signin Screen
3. Admin screen
- Admin Account Management
- Customer Account Management
- Vendor Account Management
- Category Management
- Brand Management
4. Customer Screen
- Account Management
- Address
- Upgrade Account to vendor
- Add to cart
- Confirm order and Choose payment
5. Vendor Screen
- Account Management
- All product 
- Add product
- Edit product (can't edit price)
- Disable products
6. Shop Screen
- Product detail
- Warehouse Management
- Order
- Details 

## III. CONCEPT DATABASE
  https://docs.google.com/spreadsheets/d/11HOY6Ug1ojyvybakHQizdTgF8xZgsJldb8umo4xBnUI/edit#gid=374315597
## IV. CONCEPT SCREEN

![index](https://user-images.githubusercontent.com/63025883/89864320-f26d7c80-dbd5-11ea-9a3c-c3b2b23f913c.png)


## Lưu ý
  - src/main/webapp
  - Dynamic Web Module 3.0
  - Java 1.8
  - JavaScript: 1.0
