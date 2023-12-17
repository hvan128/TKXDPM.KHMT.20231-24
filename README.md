# TKXDPM.VN.20231-24

| Name          | Role        |
| :------------ | :---------- |
| Ngô Hải Văn   | Team Leader |
| Ong Thế Tùng  | Member      |
| Vũ Anh Tuấn   | Member      |
| Tô Duy Tường  | Member      |
| Trần Anh Tuấn | Member      |

## Report Content

<details>
  <summary>W13: 27/11/2023~03/12/2023 </summary>
<br>
<details>
<summary>Ngô Hải Văn</summary>
<br>

- Assigned tasks:

  - Đánh giá các mức độ Coupling cho từng class trong package subsystem và utils
  - Tối ưu code theo coupling (nếu cần thiết)
  - Clean code

- Implementation details:
  - Pull Request(s): https://github.com/hvan128/TKXDPM.KHMT.20231-24/pull/10
  - Specific implementation details:
    - Hầu hết các hàm đều là "Data Coupling"

</details>

<details>
<summary>Ong Thế Tùng</summary>
<br>

- Assigned tasks:

  - Đánh giá coupling cho Views

- Implementation details:
  - Pull Request(s): https://github.com/hvan128/TKXDPM.KHMT.20231-24/pull/11
  - Specific implementation details:
    - Hầu hết các hàm đều là "Data Coupling"
    - Hàm removeCartMedia thuộc class MediaHandler thuộc 'Stamp coupling'
      - Giải thích: vì remove Card media chỉ cần trường 'id'

</details>

<details>
<summary>Tô Duy Tường</summary>
<br>

- Assigned tasks:

  - Đánh giá các mức độ Coupling cho từng class trong package controller
  - Tối ưu code theo coupling (nếu cần thiết)
  - Clean code

- Implementation details:
  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - Các function đều thực hiện đúng chức năng, clear rõ ràng đạtg "Data Coupling"

</details>

<details>
<summary>Vũ Anh Tuấn</summary>
<br>

- Assigned tasks:

  - Đánh giá các mức độ Coupling cho từng class trong package `entity`
  - Tối ưu code theo coupling (nếu cần thiết)
  - Clean code

- Implementation details:
  - Pull Request(s): https://github.com/hvan128/TKXDPM.KHMT.20231-24/pull/2
  - Specific implementation details:
    - Đánh giá các mức độ Coupling cho các class trong package `entity`
      - Các đánh giá xem mức độ Coupling nào sẽ được viết bên trên các hàm trong từng file implement
      - Hầu hết các hàm đều là "Data Coupling"
      - hàm `removeCartMedia` (class `Car`) và `removeOrderMedia` (class `Order`) thuộc 'Stamp Coupling':
        - Giải thích: Khi remove một đối tượng ta chỉ cần biết `id` của đối tượng đó, tuy nhiên "Stamp Coupling" trong trường hợp này được cho phép để mục đích clean code
      - các method `getMediaById`, `getAllMedia` (class `Book`, class `CD`, class `DVD`) thuộc "Content Coupling":
        - Giải thích: Đưa một phương thức trả lại giá trị `Media` trong một class không phải `Media`
        - Sửa: sửa lại phương thưc `getAllMedia` --> `getAll` + `Class`, return list of `Media` --> list of Class tương ứng
      - method `Shipment` (class `Shipment`) thuộc 'Control Coupling
        - Giải thích: Sử dụng biến điều khiển luồng `utils.Config.RUSH_ORDER`

</details>

<details>
<summary>Trần Anh Tuấn</summary>
<br>

- Assigned tasks:

  - Task 1
  - Task 2
  - ...

- Implementation details:
  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - Describe specific in detail what you did last week
    - You can attach images if you want

</details>

</details>

---

<details>
  <summary>W14: 11/12/2023~17/12/2023 </summary>
<br>
<details>
<summary>Ngô Hải Văn</summary>
<br>

- Assigned tasks:

  - Determine the cohesion type for each class or method in the subsystem package

- Implementation details:
  - Pull Request(s): https://github.com/hvan128/TKXDPM.KHMT.20231-24/pull/15
  - Specific implementation details:
    - Hầu hết các hàm đều là "Functional Cohesion"

</details>

<details>
<summary>Ong Thế Tùng</summary>
<br>

- Assigned tasks:

  - Determine the cohesion type for each class or method in views/screen

- Implementation details:
  - Pull Request(s): https://github.com/hvan128/TKXDPM.KHMT.20231-24/pull/16
  - Specific implementation details:
    - Hầu hết các hàm đều là "Functional Cohesion"

</details>

<details>
<summary>Tô Duy Tường</summary>
<br>

- Assigned tasks:

  - Task 1
  - Task 2
  - ...

- Implementation details:
  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - Describe specific in detail what you did last week
    - You can attach images if you want

</details>

<details>
<summary>Vũ Anh Tuấn</summary>
<br>

- Assigned tasks:

  - Đánh giá các mức độ Cohesion cho các class trong package `entity`
  - Kiểm tra và sửa lại cái đánh giá mức độ Coupling của tuần trước

- Implementation details:
  - Pull Request(s): [https://github.com/hvan128/TKXDPM.KHMT.20231-24/pull/16]()
  - Specific implementation details:
    - Phương thức `checkAvailabilityOfProduct` (class `Cart`) thuộc `Procedural Cohesion`
      - Giải thích: phương thức này đặt vào class `Cart` do tính tuần tự của quy trình đặt hàng có bước kiểm tra số lượng sản phẩm
      - Sửa: Nên đặt trong class `Media`
    - Phương thức `getMediaById` (class `Book`, `CD`, `DVD`) thuộc `Functional Cohesion`
      - Giải thích: phương thức đã override từ class cha để phù hợp với lớp con, phù hợp với đặc điểm của lớp con
    - Phương thức `getAllMedia` (class `Book`, `CD`, `DVD`) thuộc `Coincidental Cohesion` và `Content Coupling`
      - Giải thích: phương thức này không phù hợp để đặt ở các lớp con mà phải đặt trong lớp cha
      - Sửa: Xoá phương thức này tại các lớp con và thực hiện triển khai ở lớp cha
    - Phương thức `updateMediaFieldById` (class `Media`) thuộc `Logical Cohesion`
      - Giải thích: Phương thức này thoạt nhìn tưởng có liên quan đến class `Media` nhưng thực chất nhằm mục đích update giá trị của các trường sản phẩm, mỗi sản phẩm có các trường các nhau nên đặt trong class `Media` không hợp logic
      - Sửa: xoá phương thức này tại class `Media` và triển khai tại các lớp con

</details>

<details>
<summary>Trần Anh Tuấn</summary>
<br>

- Assigned tasks:

  - Tìm function cohesion
  - Đánh giá mức độ cohesion cho từng class trong package utils
  - Clean code

- Implementation details:
  - Pull Request(s): https://github.com/hvan128/TKXDPM.KHMT.20231-24/pull/18
  - Specific implementation details:
    - Hầu hết các hàm đều là function cohesion ở mức độ cao
    - Ở ApplicationProgramming tính chất cohesion là khá cao vì mọi phương thức đều liên quan đến việc giao tiếp với một api
      - Cả ba mức cohesion (functional, sequential, và communicational) đều thể hiện trong class này.
    - Ở configs thì các phần trong class này được nhóm lại dựa trên chức năng hoặc mục đích của chúng tạo ra một mức độ cohesion cao, chúng là các nhóm chức năng hoặc mục đích tương đối độc lập trong class.
    - Ở MyMap, các phương thức này đều thực hiện các nhiệm vụ liên quan chặt chẽ đến việc xử lý JSON và chuyển đổi giữa các kiểu dữ liệu, tạo ra một mức độ cohesion cao trong class
    - Ở Utils, tất cả các phương thức này tập trung vào các chức năng cụ thể và đều thực hiện các nhiệm vụ liên quan chặt chẽ đến chủ đề cụ thể của class nên mức độ cohesion xuất hiện trong nhiều phương thức cao

</details>

</details>

---

<details>
  <summary>W15: 18/12/2023~24/12/2023 </summary>
<br>
<details>
<summary>Ngô Hải Văn</summary>
<br>

- Assigned tasks:

  - Task 1
  - Task 2
  - ...

- Implementation details:
  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - Describe specific in detail what you did last week
    - You can attach images if you want

</details>

<details>
<summary>Ong Thế Tùng</summary>
<br>

- Assigned tasks:

  - Task 1
  - Task 2
  - ...

- Implementation details:
  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - Describe specific in detail what you did last week
    - You can attach images if you want

</details>

<details>
<summary>Tô Duy Tường</summary>
<br>

- Assigned tasks:

  - Task 1
  - Task 2
  - ...

- Implementation details:
  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - Describe specific in detail what you did last week
    - You can attach images if you want

</details>

<details>
<summary>Vũ Anh Tuấn</summary>
<br>

- Assigned tasks:

  - Đánh giá SOLID của các class trong package `enity`

- Implementation details:

  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - SOLID:
      - Hầu hết các class đều tuân thủ tốt theo SOLID - Việc tách `CartMedia`, `OrderMedia` với `Media` đảm bảo SRP: mỗi lớp thực hiện 1 chức năng `CartMedia` chịu trách nhiệm với các sản phẩm trong `Cart` (chỉ thể hiện các thông tin cần thiết) Media quản lý thông tin của sản phẩm nói chung, bao gồm `Book`, `CD`, `DVD`.
      - Việc tách lớp `Media` thành các lớp con `Book`, `CD`, `DVD` để mỗi lớp con thực hiện đúng một trách nhiệm duy nhất liên quan đến sản phẩm của mình.
      - Đảm bảo tốt nguyên tắc OCP: Phương thức `getMediaById` được kế thừa bởi các lớp con, dễ dàng cho việc mở rộng mà không cần chỉnh sửa trong lớp này.
    - Update Coupling - Cohesion:
      - Một số class đang có Coupling và Cohesion thấp (tương tác thấp) do sử dụng hàm getter/setter cho từng thuộc tính
      - Chỉnh sửa: Gộp hết thành một hàm getter cho class (nếu class đó không đòi hỏi phải lấy thông tin từng thuộc tính)

  </details>

<details>
<summary>Trần Anh Tuấn</summary>
<br>

- Assigned tasks:

  - Task 1
  - Task 2
  - ...

- Implementation details:
  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - Describe specific in detail what you did last week
    - You can attach images if you want

</details>

</details>

---

<details>
  <summary>W16: 25/12/2023~1/31/2023 </summary>
<br>
<details>
<summary>Ngô Hải Văn</summary>
<br>

- Assigned tasks:

  - Task 1
  - Task 2
  - ...

- Implementation details:
  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - Describe specific in detail what you did last week
    - You can attach images if you want

</details>

<details>
<summary>Ong Thế Tùng</summary>
<br>

- Assigned tasks:

  - Task 1
  - Task 2
  - ...

- Implementation details:
  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - Describe specific in detail what you did last week
    - You can attach images if you want

</details>

<details>
<summary>Tô Duy Tường</summary>
<br>

- Assigned tasks:

  - Task 1
  - Task 2
  - ...

- Implementation details:
  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - Describe specific in detail what you did last week
    - You can attach images if you want

</details>

<details>
<summary>Vũ Anh Tuấn</summary>
<br>

- Assigned tasks:

  - Task 1
  - Task 2
  - ...

- Implementation details:
  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - Describe specific in detail what you did last week
    - You can attach images if you want

</details>

<details>
<summary>Trần Anh Tuấn</summary>
<br>

- Assigned tasks:

  - Task 1
  - Task 2
  - ...

- Implementation details:
  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - Describe specific in detail what you did last week
    - You can attach images if you want

</details>

</details>

---
