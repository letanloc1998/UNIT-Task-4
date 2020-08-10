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
    use DMS_DEV;

        drop table p2p_bill_item;
        drop table p2p_bill;
        drop table p2p_cart;
        drop table p2p_product_tag;
        drop table p2p_product;
        drop table p2p_brand;
        drop table p2p_tag;
        drop table p2p_category;
        drop table p2p_shop;
        drop table p2p_account_role;
        drop table p2p_role;
        drop table p2p_account;

    
    create table p2p_account (
        id bigint primary key identity(1,1),
        name nvarchar(50),
        username nvarchar(50) not null,
        password nvarchar(50) not null,
        email nvarchar(50),
        phone nvarchar(20),
        active bit default 0,
        create_at datetime default getutcdate(),
    )

    create table p2p_role (
        id smallint primary key identity(1,1),
        name nvarchar(50) not null
    )

    create table p2p_account_role (
        account bigint,
        role smallint,
        constraint pk_p2p_account_role primary key (account, role),
        constraint fk_account_role_account__account_id foreign ke(account) references p2p_account(id),
        constraint fk_account_role_role__role_id foreign key (role) references  p2p_role(id)
    )

    create table p2p_shop (
        id bigint primary key,
        constraint fk_shop_id foreign key (id) references p2p_account(id),
        name nvarchar(50) not null,
        address nvarchar(255),
        email nvarchar(50),
        phone nvarchar(50),
        detail nvarchar(500),
        disable bit default 0,
        create_at datetime default getutcdate()
    )    

    create table p2p_category (
        id int primary key identity(1,1),
        name varchar(50) not null
    )

    create table p2p_tag (
        id bigint primary key identity(1,1),
        name nvarchar(10),
    )

    create table p2p_brand (
        id int primary key identity(1,1),
        name nvarchar(50),
    )

    create table p2p_product (
        id bigint primary key identity(1,1),

        shop bigint,
        constraint fk_produtc_shop__shop_id foreign key (shop) references p2p_shop(id),

        name varchar(255) not null,
        price int not null,
        detail nvarchar(1000),
        img nvarchar(500),
        disable bit default 0,

        category int,
        constraint fk_product_category__category_id foreign key (category) references p2p_category(id),

        brand int,
        constraint fk_product_brand__brand_id foreign key (brand) references p2p_brand(id),
        
        create_at datetime default getutcdate()
    )

    create table p2p_product_tag (
        product bigint,
        tag bigint,

        constraint pk_product_tag primary key (product, tag),
        constraint fk_product_tag_product__product_id foreign key (product) references p2p_product(id),
        constraint fk_product_tag_tag__tag_id foreign key (tag) references p2p_tag(id)
    )

    create table p2p_cart (
        account bigint,

        product bigint,

        create_at datetime default getutcdate(),

        constraint pk_p2p_cart primary key (account, product),
        constraint fk_cart_account__account_id foreign key (account) references p2p_account(id),
        constraint fk_cart_product__product_id foreign key (product) references p2p_product(id)
    )

    create table p2p_bill (
        id bigint primary key identity(1,1),
        account bigint,
        address nvarchar(255),
        create_at datetime default getutcdate(),

        constraint fk_bill_account__account_id foreign key (account) references p2p_account(id),
    )

    create table p2p_bill_item (
        id bigint,
        constraint fk_bill_item_id__bill_id foreign key (id) references p2p_bill(id),

        product bigint not null,
        constraint fk_bill_item_product__product_id foreign key (product) references p2p_product(id),

        quantity bigint not null

    )

    -- init data
    insert into p2p_account(username, password) values ('admin', '');
    insert into p2p_account(username, password) values ('vendor', '');
    insert into p2p_account(username, password) values ('user', '');

    insert into p2p_role (name) values ('ROLE_ADMIN');
    insert into p2p_role (name) values ('ROLE_VENDOR');
    insert into p2p_role (name) values ('ROLE_USER');

    insert into p2p_account_role (account, role) values (1, 1);
    insert into p2p_account_role (account, role) values (2, 2);
    insert into p2p_account_role (account, role) values (3, 3);