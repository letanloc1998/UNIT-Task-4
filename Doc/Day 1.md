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
  * Nhấn vào tên người dùng để chuyển đến trang cá nhân.

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

10. Giao diện tài khoản

  * Người dùng có thể điền username và password rồi nhấn "change" để thay đổi thông tin.
  * Nhấn "Information" để tới giao diện thông tin người dùng.
  * Nhấn "Your Order" để chuyển tới giao diện đơn hàng người dùng.
  * Nhấn "Create shop" để chuyển đến giao diện tạo cửa hàng.
  * Nhấn "Back to home" để trở về trang index.

![user_management](https://user-images.githubusercontent.com/63025883/89969382-70865d80-dc80-11ea-90d7-517a22d07102.png)

11. Giao diện thông tin người dùng

  * Người dùng có thể thay đổi số điện thoại hoặc email rồi nhấn "Change".

![user_info](https://user-images.githubusercontent.com/63025883/89969408-8431c400-dc80-11ea-9c08-ff0aca687f91.png)

12. Giao diện đơn hàng người dùng

  * Nhấn "View" đế chuyến đến giao diện chi tiết đơn hàng.
  * Nhấn "Cancel" để đến giao diện hủy đơn hàng.

![order](https://user-images.githubusercontent.com/63025883/89969448-9c094800-dc80-11ea-98a6-20dc5750545e.png)

13. Giao diện chi tiết đơn hàng và hủy đơn hàng

  * Nhấn "Cancel" để hủy đơn hàng.

![cancel_order](https://user-images.githubusercontent.com/63025883/89969478-adeaeb00-dc80-11ea-8f8d-325e42c8d530.png)

14. Giao diện tạo cửa hàng

  * Người dùng điền đầy đủ thông tin và nhấn nút "Create" để tiến hành tạo cửa hàng.

![create_shop](https://user-images.githubusercontent.com/63025883/89969514-c8bd5f80-dc80-11ea-96e6-8733a7474317.png)


### VENDOR
1. Trang Vendor
  * Nhấn vào Tên cửa hàng để chuyển đến trang của hàng của mình.
  * Nhấn nút Add để thêm sản phẩm vào giỏ hàng.
  * Nhấn vào name để đến trang xem chi tiết sản phẩm.
  * Nhấn vào tên người dùng để vào trang tài khoản( tương tự user).

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

  * Vendor điền đầy đủ thông tin và nhấn "Add" để thêm sản phẩm.

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

  * Nhấn "Admin Management" để chuyển đến trang admin.

![index_ad](https://user-images.githubusercontent.com/63025883/89970952-2dc68480-dc84-11ea-9ce4-d0c8b74ac6d6.png)

2. Giao diện trang admin

  * Nhấn vào tên người dùng để chuyển đến trang tài khoản(tương tự như user).
  * Nhấn "Account" để chuyển qua giao diện quản lí tài khoản người dùng.
  * Nhấn "Shop" để chuyển qua giao diện quản lí tài khoản shop.
  * Nhấn "Category" chuyến đến giao diện quản lí loại sản phẩm.

![ad](https://user-images.githubusercontent.com/63025883/89970974-3dde6400-dc84-11ea-9b32-200a9d49b7df.png)

3. Giao diện quản lí tài khoản người dùng

  * Nhấn "Add" để chuyển đến trang thêm tài khoản người dùng.
  * Nhấn "Edit" để chuyển đến trang sửa tài khoản người dùng.
  * Nhấn "Del" để chuyển đến giao diện khóa tài khoản người dùng.

![ad_account](https://user-images.githubusercontent.com/63025883/89971054-6b2b1200-dc84-11ea-9411-41941bf99f69.png)

4. Giao diện thêm tài khoản

  * Admin điền đầy đủ thông tin và nhấn "Add" để thêm người dùng.

![ad_account_add](https://user-images.githubusercontent.com/63025883/89971083-7da54b80-dc84-11ea-80de-e2c35a7f06ac.png)

5. Giao diện khóa tài khoản người dùng

  * Nhấn "Delete" để khóa tài khoản người dùng.

![ad_account_del](https://user-images.githubusercontent.com/63025883/89971167-b6ddbb80-dc84-11ea-85c2-1d0ee4480999.png)

6. Giao diện sửa tài khoản người dùng

  * Chọn "Role" muốn chỉnh sửa và nhấn "Edit".

![ad_account_edit](https://user-images.githubusercontent.com/63025883/89971187-c65d0480-dc84-11ea-8a56-2ec1ac121d48.png)

7. Giao diện xem loại sản phẩm

  * Nhấn "Add" để chuyển đến trang thêm loại sản phẩm.
  * Nhấn "Edit" để chuyển đến trang sửa loại sản phẩm.
  * Nhấn "Del" để chuyển đến giao diện xóa loại sản phẩm.

![ad_category](https://user-images.githubusercontent.com/63025883/89971215-dbd22e80-dc84-11ea-801b-6206545f4c44.png)

8. Giao diện thêm loại sản phẩm

  * Điền loại sản phẩm muốn thêm và nhấn nút "Add".

![ad_category_add](https://user-images.githubusercontent.com/63025883/89971251-f1475880-dc84-11ea-9c29-ebaee6f547b5.png)

9. Giao diện xóa loại sản phẩm

  * Kiểm tra thông tin và nhấn "Delete" để xóa loại sản phẩm.

![ad_category_del](https://user-images.githubusercontent.com/63025883/89971280-0623ec00-dc85-11ea-9b9a-1ae39f6dc013.png)

10. Giao diện sửa loại sản phẩm

  *  Chỉnh sửa thông tin và nhấn "Edit" để sửa loại sản phẩm.

![ad_category_edit](https://user-images.githubusercontent.com/63025883/89971303-1936bc00-dc85-11ea-8965-a94fe775527a.png)

11. Giao diện khóa tài khoản cửa hàng

  * Kiểm tra thông tin và nhấn "Delete" để khóa tài khoản cửa hàng.

![ad_delshop](https://user-images.githubusercontent.com/63025883/89971354-353a5d80-dc85-11ea-8a19-8b59dfaa7cee.png)

12. Giao diện trang quản lí cửa hàng

  * Nhấn "Edit" để chuyển tới giao diện duyệt cửa hàng.
  * Nhấn "Del" để chuyển tới giao diện khóa cửa hàng.

![ad_shop](https://user-images.githubusercontent.com/63025883/89971389-4d11e180-dc85-11ea-81d7-870489b8d58a.png)

13. Giao diện duyệt cửa hàng

  * Chọn lại trạng thái cửa hàng và nhấn "Edit".

![ad_shop_edit](https://user-images.githubusercontent.com/63025883/89974646-ce6d7200-dc8d-11ea-8183-a0bee00028b7.png)


## Lưu ý
  - src/main/webapp
  - Dynamic Web Module 3.0
  - Java 1.8
  - JavaScript: 1.0
