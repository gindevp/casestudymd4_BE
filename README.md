# casestudymd4_vn_social_network
FE:
https://github.com/NguyenManhHien12797/caseStudy4_FE

Ý tưởng:
- Web social tạo ra nhằm giúp mọi người có thể viết nội dung và đăng tải lên mạng về một chủ đề, đồng thời muốn chia sẽ nó cho cộng đồng. Ví dụ bạn đang vận hành một việc kinh doanh và cần nó giúp để bán sản phẩm tốt hơn, tiếp cận nhiều khách hàng hơn bằng cách giải thích thêm cho sản phẩm.
- Các chức năng chính: quản lí người dùng(bloger), quản lý blog, quản lý thể loại, quản lý bình luận(comment),  quản lý danh sách blog ưa thích (favorite), quản lý phản ánh( report),  ...
- Người dùng: admin và bloger ( đăng nhập vs role bloger hay chưa đăng nhập tạm gọi là viewer đều có thể xem blog nhưng muốn dùng chức năng thì phải tạo tk hoặc đăng nhập)
- Admin có thể quản lý tất cả, còn bloger thì có thể quản lý blog, quản lý bình luận (của chính mình), quản lý danh sách blog ưa thích,còn viewer có cái nịt.
Thực tế:
- Giống facebook
- Còn sơ xài do thời gian có hạn

config:
- Tạo local.env
JDBC_DATABASE_URL=jdbc:mysql://localhost:3306/VN_Social_Network?createDatabaseIfNotExist=true&useUnicode=yes&characterEncoding=UTF-8
JDBC_DATABASE_USERNAME=root
JDBC_DATABASE_PASSWOERD=123456
JDBC_DATABASE_DRIVER=com.mysql.cj.jdbc.Driver
SPRING_JPA_HIBERNATE_DIALECT=org.hibernate.dialect.MySQL5Dialect
linkanh=C:\\Users\\Huu Quyet\\OneDrive\\Máy tính\\case_study4\\caseStudy4_FE\\images\\
