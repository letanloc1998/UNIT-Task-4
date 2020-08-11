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
### USER

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

3. Giao diện đăng ký người dùng
  * Người dùng điền đầy đủ thông tin và nhấn nút Register để đăng kí tài khoản người dùng.

![register](https://user-images.githubusercontent.com/63025883/89875328-5187bd00-dbe7-11ea-8bcd-c5af913f93e3.png)

4. Giao diện chi tiết sản phẩm
  * Người dùng nhấn vào 2 button "+" hoặc "-" để chọn số lượng sản phẩm muốn mua.
  * Nhấn nút "Add to cart" đế thêm sản phẩm vào giỏ hàng.
  * Người dùng nhấn vào tên cửa hàng để chuyển đến trang cửa hàng(shop_name).

![product_detail](https://user-images.githubusercontent.com/63025883/89868464-0b2d6080-dbdd-11ea-984a-1c09162fc98e.png)

5. Giao diện giỏ hàng
  * Nhấn vào button "Del" đế xóa sản phẩm khỏi giở hàng.
  * Nhấn vào nút "Next" để chuyến đến trang "Detail order".

![cart](https://user-images.githubusercontent.com/63025883/89875663-bb07cb80-dbe7-11ea-9f9a-da59c6a5db13.png)

6. Giao diện trang chi tiết đơn hàng
  * Thông tin người dùng nhận hàng có thể lấy từ hệ thống hoặc cho người dùng nhập vào.
  * Chọn hình thức thanh toán: Momo hoặc Paypal.

![confirm_order](https://user-images.githubusercontent.com/63025883/89866211-5ba2bf00-dbd9-11ea-9d6f-cbca31463d84.png)

7. Giao diện sản phẩm người dùng tìm kiếm.
  * Nhấn vào tên sản phẩm để đến trang chi tiết sản phẩm.
  * Nhấn vào button "Add" để thêm sản phẩm vào giở hàng.

![product_search](https://user-images.githubusercontent.com/63025883/89866310-842ab900-dbd9-11ea-843e-a736830aa096.png)

8. Giao diện cửa hàng
  * Nhấn vào tến sản phẩm để chuyển đến trang xem chi tiết sản phẩm.
  * Nhấn nút "Add" để thêm sản phẩm vào giỏ hàng.

![shop](https://user-images.githubusercontent.com/63025883/89866468-c8b65480-dbd9-11ea-8845-6ae6f03c7599.png)

9. Giao diện thanh toàn thành công
  * Nhấn vào button "Continue shopping" để trở về trang chủ.

![success](https://user-images.githubusercontent.com/63025883/89866529-e7b4e680-dbd9-11ea-8519-9de5799a3aae.png)


### VENDOR
1. Trang Vendor
  * Nhấn vào Tên cửa hàng để chuyển đến trang của hàng của mình.
  * Nhấn nút Add để thêm sản phẩm vào giỏ hàng.
  * Nhấn vào name để đến trang xem chi tiết sản phẩm.

![index_vendor](https://user-images.githubusercontent.com/63025883/89879804-ac241780-dbed-11ea-9a76-5d7040c74112.png)

2. Giao diện cửa hàng của Vendor
  * Nhấn vào button "Shop Management" để đến trang quản lí sản phẩm.

![shop_detail](https://user-images.githubusercontent.com/63025883/89880171-23f24200-dbee-11ea-95d2-25daedde30ff.png)

3. Giao diện quản lí sản phẩm
  * Nhấn "Back to shop " để trờ về trang cửa hàng.
  * Nhấn "Del" đến trang xóa sản phẩm.
  * Nhấn "Edit" đến trang sửa sản phẩm.
  * Nhấn "Add product" chuyển đến giao diện thêm sản phẩm.
  * Nhấn "Order" chuyến đến giao diện chi tiết đơn hàng.

![allproduct](https://user-images.githubusercontent.com/63025883/89880108-0f15ae80-dbee-11ea-9866-69fb511e294f.png)

4. Giao diện thêm sản phẩm

  * Vendor điền đầy đủ thông tin và nhấn "Add để thêm sản phẩm".

![addproduct](https://user-images.githubusercontent.com/63025883/89880490-851a1580-dbee-11ea-87fa-6a1756a42041.png)

5. Giao diện xem đơn hàng
  * Nhấn "Cancel" để đến trang hủy đơn hàng.
  * Nhấn "View" để đến trang chi tiết đơn hàng.

![order](https://user-images.githubusercontent.com/63025883/89881034-299c5780-dbef-11ea-9e18-f7039d907bc9.png)

6. Giao diện sửa sản phẩm

  * Vendor chọn thông tin cần chỉnh sửa và nhấn "Edit" để lưu thông tin.

![editproduct](https://user-images.githubusercontent.com/63025883/89880298-45532e00-dbee-11ea-9548-2ca1e7ddfa8b.png)

7. Giao diện xóa sản phẩm
  * Vendor kiểm tra lại thông tin sản phẩm cần xóa và nhấn "Delete" để xóa.

![del](https://user-images.githubusercontent.com/63025883/89881349-9b74a100-dbef-11ea-870e-7ac4ce4cf184.png)  

8. Giao diện xem chi tiết đơn hàng
  * Nhấn "Cancel Detail" để chuyến đến trang hủy đơn hàng.
  * Nhấn "Back" để trở về trang chi tiết đơn hàng.

![order_detail](https://user-images.githubusercontent.com/63025883/89888080-91f03680-dbf9-11ea-8a65-fe5d98ccc42c.png)

9. Giao diện hủy đơn hàng
  * Nhấn nút "OK" để xác nhận hủy đơn hàng.
  * Nhấn "Cancel" hủy bỏ hủy đơn hàng.

![cancel_order](https://user-images.githubusercontent.com/63025883/89882318-dc20ea00-dbf0-11ea-9aa2-36a3518ebefc.png)

### ADMIN 

1. Giao diện trang chủ

2. Giao diện trang admin

3.
## Lưu ý
  - src/main/webapp
  - Dynamic Web Module 3.0
  - Java 1.8
  - JavaScript: 1.0
