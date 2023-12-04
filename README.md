<details>
  <summary>W13: 27/11/2023~03/12/2023 </summary>
<br>
<details>
<summary>Tô Duy Tường</summary>
<br>

- Assigned tasks:

  - Find Coupling in Subsystem and Utils

- Implementation details:
  - Pull Request(s): https://github.com/hvan128/TKXDPM.KHMT.20231-24/pull/1
  - Specific implementation details:
    - Add comment coupling range in subsystem and utils

</details>

<details>
<summary>Ong Thế Tùng</summary>
<br>

- Assigned tasks:
  - Đánh giá coupling cho Views

- Implementation details:
  - Pull Request(s): https://github.com/hvan128/TKXDPM.KHMT.20231-24/tree/feature/tung
  - Specific implementation details:
    - Hầu hết các hàm đều là "Data Coupling"
    - Hàm removeCartMedia thuộc class MediaHandler thuộc 'Stamp coupling'
      - Giải thích: vì remove Card media chỉ cần trường 'id'

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

</details>

</details>
