# Major Assignment : Bomberman Game
## 1. Thành viên: 
 - Nguyễn Phú Lộc - MSV: 22022547
 - Nguyễn Duy Minh Lâm - MSV: 2202605
 - Nguyễn Quang Huy - MSV: 22022582
 - Bùi Ngọc Khánh - MSV: 22022551

## 2. Giới thiệu trò chơi
 Bomberman là một trò chơi kinh điểm của NES. Người chơi điều khiển nhân vật tên Bomberman tiêu diệt các Enemy và tìm đường vượt qua các ải theo cấp độ khó tăng dần.
## 3. Mô tả về các đối tượng trong trò chơi
Nếu bạn đã từng chơi Bomberman, bạn sẽ cảm thấy quen thuộc với những đối tượng này. Chúng được được chia làm hai loại chính là nhóm đối tượng động (*Bomber*, *Enemy*, *Bomb*) và nhóm đối tượng tĩnh (*Grass*, *Wall*, *Brick*, *Door*, *Item*).
- ![](BombermanGame/src/res/sprites/player_down.png) *Bomber* là nhân vật chính của trò chơi. Bomber có thể di chuyển theo 4 hướng trái/phải/lên/xuống theo sự điều khiển của người chơi.
- ![](BombermanGame/src/res/sprites/balloom_left1.png) *Enemy* là các đối tượng mà Bomber phải tiêu diệt hết để có thể qua Level. Enemy có thể di chuyển ngẫu nhiên hoặc tự đuổi theo Bomber tùy theo loại Enemy. Các loại Enemy sẽ được mô tả cụ thể ở phần dưới.
- ![](BombermanGame/src/res/sprites/bomb.png) *Bomb* là đối tượng mà Bomber sẽ đặt và kích hoạt tại các ô Grass. Khi đã được kích hoạt, Bomber và Enemy không thể di chuyển vào vị trí Bomb. Tuy nhiên ngay khi Bomber vừa đặt và kích hoạt Bomb tại ví trí của mình, Bomber có một lần được đi từ vị trí đặt Bomb ra vị trí bên cạnh. Sau khi kích hoạt 2s, Bomb sẽ tự nổ, các đối tượng *Flame* ![](BombermanGame/src/res/sprites/explosion_horizontal.png) được tạo ra.


- ![](BombermanGame/src/res/sprites/grass.png) *Grass* là đối tượng mà Bomber và Enemy có thể di chuyển xuyên qua, và cho phép đặt Bomb lên vị trí của nó
- ![](BombermanGame/src/res/sprites/wall.png) *Wall* là đối tượng cố định, không thể phá hủy bằng Bomb cũng như không thể đặt Bomb lên được, Bomber và Enemy không thể di chuyển vào đối tượng này
- ![](BombermanGame/src/res/sprites/brick.png) *Brick* là đối tượng được đặt lên các ô Grass, không cho phép đặt Bomb lên nhưng có thể bị phá hủy bởi Bomb được đặt gần đó. Bomber và Enemy thông thường không thể di chuyển vào vị trí Brick khi nó chưa bị phá hủy.


- ![](BombermanGame/src/res/sprites/portal.png) *Portal* là đối tượng được giấu phía sau một đối tượng Brick. Khi Brick đó bị phá hủy, Portal sẽ hiện ra và nếu tất cả Enemy đã bị tiêu diệt thì người chơi có thể qua Level khác bằng cách di chuyển vào vị trí của Portal.

Các *Item* cũng được giấu phía sau Brick và chỉ hiện ra khi Brick bị phá hủy. Bomber có thể sử dụng Item bằng cách di chuyển vào vị trí của Item. Thông tin về chức năng của các Item được liệt kê như dưới đây:
- ![](BombermanGame/src/res/sprites/powerup_speed.png) *SpeedItem* Khi sử dụng Item này, Bomber sẽ được tăng vận tốc di chuyển thêm một giá trị thích hợp
- ![](BombermanGame/src/res/sprites/powerup_flames.png) *FlameItem* Item này giúp tăng phạm vi ảnh hưởng của Bomb khi nổ (độ dài các Flame lớn hơn)
- ![](BombermanGame/src/res/sprites/powerup_bombs.png) *BombItem* Thông thường, nếu không có đối tượng Bomb nào đang trong trạng thái kích hoạt, Bomber sẽ được đặt và kích hoạt duy nhất một đối tượng Bomb. Item này giúp tăng số lượng Bomb có thể đặt thêm một.
- ![](BombermanGame/src/res/sprites/powerup_wallpass.png) *WallpassItem* Item này giúp Bomber có khả năng đi qua những loại gạch có thể bị phá huỷ, giống như những loại enemy Kondoria, Ovapi hay Pontan 
- ![](BombermanGame/src/res/sprites/powerup_flamepass.png) *FlamepassItem* Giúp Bomber có khả năng miễn nhiễm với các tia lửa của bomb 
- ![](BombermanGame/src/res/sprites/powerup_bombpass.png) *BombpassItem* Giúp bomber có khả năng đi qua bomb

Có 8 loại Enemy trong Bomberman

| Enemy                               | Name     | Points | Speed  | Smart   | Wallpass | Finding Scope |
|-------------------------------------|----------|--------|--------|---------|----------|---------------|
| ![](BombermanGame/src/res/sprites/balloom_left1.png)  | Balloom  | 100    | 1      | level 1 | No       | N/A           |
| ![](BombermanGame/src/res/sprites/oneal_left1.png)    | Oneal    | 200    | 1 or 2 | level 2 | No       | N/A           |
| ![](BombermanGame/src/res/sprites/doll_left1.png)     | Doll     | 400    | 2      | level 2 | No       | N/A           |
| ![](BombermanGame/src/res/sprites/minvo_left1.png)    | Minvo    | 800    | 1      | level 3 | No       | 5             |
| ![](BombermanGame/src/res/sprites/ovapi.png)          | Ovapi    | 1000   | 1      | level 3 | Yes      | 5             |
| ![](BombermanGame/src/res/sprites/kondoria_left1.png) | Kondoria | 2000   | 1      | level 4 | Yes      | 7             |
| ![](BombermanGame/src/res/sprites/pass.png)           | Pass     | 4000   | 2      | level 4 | No       | 5             |
| ![](BombermanGame/src/res/sprites/pontan.png)         | Pontan   | 8000   | 2      | level 4 | Yes      | 7 |

Độ thông minh của quái
- Level 1: Enemy đi random 
- Level 2: Enemy có khả năng đuổi người chơi trong phạm vi hình vuông có cạnh là finding scope * 2 với enemy là tâm của hình vuông 
- Level 3: Enemy đuổi theo Bomberman theo thuật toán A* (A* algorithm) 

## 4. Mô tả game play, xử lý va chạm và xử lý bom nổ
- Trong một màn chơi, Bomber sẽ được người chơi di chuyển, đặt và kích hoạt Bomb với mục tiêu chính là tiêu diệt tất cả Enemy và tìm ra vị trí Portal để có thể qua màn mới
- Bomber sẽ bị giết khi va chạm với Enemy hoặc thuộc phạm vi Bomb nổ. Lúc đấy trò chơi kết thúc.
- Enemy bị tiêu diệt khi thuộc phạm vi Bomb nổ
- Một đối tượng thuộc phạm vi Bomb nổ có nghĩa là đối tượng đó va chạm với một trong các tia lửa được tạo ra tại thời điểm một đối tượng Bomb nổ.

- Khi Bomb nổ, một Flame trung tâm![](BombermanGame/src/res/sprites/bomb_exploded.png) tại vị trí Bomb nổ và bốn Flame tại bốn vị trí ô đơn vị xung quanh vị trí của Bomb xuất hiện theo bốn hướng trên![]BombermanGame/src/(res/sprites/explosion_vertical.png)/dưới![](BombermanGame/src/res/sprites/explosion_vertical.png)/trái![](BombermanGame/src/res/sprites/explosion_horizontal.png)/phải![](BombermanGame/src/res/sprites/explosion_horizontal.png). Độ dài bốn Flame xung quanh mặc định là 1 đơn vị, được tăng lên khi Bomber sử dụng các FlameItem.
- Khi các Flame xuất hiện, nếu có một đối tượng thuộc loại Brick/Wall nằm trên vị trí một trong các Flame thì độ dài Flame đó sẽ được giảm đi để sao cho Flame chỉ xuất hiện đến vị trí đối tượng Brick/Wall theo hướng xuất hiện. Lúc đó chỉ có đối tượng Brick/Wall bị ảnh hưởng bởi Flame, các đối tượng tiếp theo không bị ảnh hưởng. 

## 5. Các phím điều khiển

| Control |  Key  |
|---------|-------|
| UP      |  ↑    | 
| DOWN    |  ↓    | 
| LEFT    |  ←    |
| RIGHT   |  →    | 
| BOMB    | SPACE | 

<!-- | Option       | Key                 |
|--------------|---------------------|
| New Game     | Ctrl + N            |
| Restart      | Ctrl + O            |
| Pause        | Ctrl + P            |
| Resume       | Ctrl + P            |
| Exit         | Ctrl + W / Alt + F4 |
| Change level | Shift + level       | -->

## 6. Điểm đặc biệt của game
- Có set up để kết nối với thiết bị điện thoại để sử dụng như 1 remote controller, giúp cho người dùng có thể dễ dàng trải nghiệm game hơn
- Có chế độ chọn màn chơi, cho phép người chơi trải nghiệm tất cả các map 
- Hết 120s đếm ngược thì toàn bộ quái sẽ biến thành Pontan để đuổi theo người chơi
- Điểm được lưu lại qua các màn chơi, leaderboard có thể lưu được top 3 điểm cao nhất
- Có thể tuỳ chỉnh âm lượng tuỳ ý người chơi
- Quái được xử lí với nhiều chế độ thông minh khác nhau từ thấp, trung bình, đến rất thông minh
- Khi quái chết có hiện điểm của quái trên màn hình

## 7. Chức năng đã làm theo yêu cầu
1. Thiết kế cây thừa kế cho các đối tượng game
2. Xây dựng bản đồ màn chơi từ tệp cấu hình.
3. Di chuyển Bomber theo sự điều khiển từ người chơi.
4. Tự động di chuyển các Enemy.
5. Xử lý va chạm cho các đối tượng Bomber, Enemy, Wall, Brick, Bomb.
6. Xử lý bom nổ.
7. Xử lý khi Bomber sử dụng các Item và khi đi vào vị trí Portal.

8. Nâng cấp thuật toán tìm đường cho Enemy. (bằng thuật toán A* và 1 thuật toán đơn giản khác)
9. Cài đặt thêm các loại Enemy khác.
10. Xử lý hiệu ứng âm thanh (thêm music & sound effects).

## 8. Thư viện, IDE sử dụng
- Visual Studio Code
- IntelliJ IDEA Community Edition 
- JavaFx
- Maven Framework

## 9. Demo

