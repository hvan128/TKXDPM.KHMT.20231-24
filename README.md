# TKXDPM.VN.20231-24


| Name             | Role        |
| :----------------| :---------- |
| Ngô Hải Văn      | Team Leader |
| Ong Thế Tùng     | Member      |
| Vũ Anh Tuấn      | Member      |
| Tô Duy Tường     | Member      |
| Trần Anh Tuấn    | Member      |


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


