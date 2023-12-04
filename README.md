# TKXDPM.VN.20231-24

| Name         | Role        |
| :----------- | :---------- |
| Ngô Hải Văn  | Team Leader |
| Vũ Anh Tuấn  | Member      |
| Nguyễn Văn B | Member      |

## Report Content

<details>
  <summary>W13: 27/11/2023~03/12/2023 </summary>
<br>
<details>
<summary>Ngô Hải Văn</summary>
<br>

- Assigned tasks:

  - Find Coupling in Subsystem and Utils

- Implementation details:
  - Pull Request(s): https://github.com/hvan128/TKXDPM.KHMT.20231-24/pull/1
  - Specific implementation details:
    - Add comment coupling range in subsystem and utils

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

</details>

---

<details>
  <summary>W2: 01/10/2023~08/10/2023 </summary>
<br>
<details>
<summary>Team Member 1</summary>
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
<summary>Team Member 2</summary>
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
