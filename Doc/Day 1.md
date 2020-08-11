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
1.  Giao diện trang chủ.
  * Người dùng nhấn vào Login để chuyển đến trang đăng nhập.
  * Người dùng chưa có tài khoản nhấn vào Register để đăng kí.
  * Người dùng nhấn vào cart để đến trang giỏ hàng.
  * Người dùng nhấn vào button category để chuyến đến trang category.
  * Người dùng nhập thông tin vào search box và nhấn button "Search" để chuyến trang produc_search.
  * Người dùng nhấn vào tên sản phẩm đế chuyến đến trang xem chi tiết sản phẩm (product_detail).
  * Nhấn nút add để thêm sản phảm vào giỏ hàng.

![index](https://user-images.githubusercontent.com/63025883/89864320-f26d7c80-dbd5-11ea-9a3c-c3b2b23f913c.png)

2. Giao diện đăng nhập
  * Người dùng điền username và password rồi nhấn "login" để đăng nhập vào trang người dùng.
  
![image](https://user-images.githubusercontent.com/63025883/89865026-2bf2b780-dbd7-11ea-9dc5-eb25b38ed181.png)

![register](https://user-images.githubusercontent.com/63025883/89866411-aae8ef80-dbd9-11ea-8e1f-1f9c3a5353fd.png)

![cart](https://user-images.githubusercontent.com/63025883/89866021-04045380-dbd9-11ea-9c37-f0bfa0e54f91.png)

![product_detail](https://user-images.githubusercontent.com/63025883/89868464-0b2d6080-dbdd-11ea-984a-1c09162fc98e.png)

![confirm_order](https://user-images.githubusercontent.com/63025883/89866211-5ba2bf00-dbd9-11ea-9d6f-cbca31463d84.png)

![product_search](https://user-images.githubusercontent.com/63025883/89866310-842ab900-dbd9-11ea-843e-a736830aa096.png)

![shop](https://user-images.githubusercontent.com/63025883/89866468-c8b65480-dbd9-11ea-8845-6ae6f03c7599.png)

![success](https://user-images.githubusercontent.com/63025883/89866529-e7b4e680-dbd9-11ea-8519-9de5799a3aae.png)

## Lưu ý
  - src/main/webapp
  - Dynamic Web Module 3.0
  - Java 1.8
  - JavaScript: 1.0
