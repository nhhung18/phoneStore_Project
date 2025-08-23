function showSection(sectionId) {
  // Ẩn tất cả sections
  const sections = document.querySelectorAll(".content-section");
  sections.forEach((section) => {
    section.classList.remove("active");
  });

  // Hiện section được chọn
  document.getElementById(sectionId).classList.add("active");

  // Update active menu
  const menuItems = document.querySelectorAll(".menu a");
  menuItems.forEach((item) => {
    item.classList.remove("active");
  });
  event.target.classList.add("active");
}

var listProduct = [];
var listCapacity = [];
var listColor = [];
var currentPage = 1;
var currentSize = 5;

getListProduct();

// HÀM LIÊN QUAN ĐẾN PRODUCT
function getListProduct() {
  // jqajax
  $.ajax({
    type: "GET",
    url: `http://localhost:8080/product?page=${currentPage}&size=${currentSize}`,
    // data: "data",
    dataType: "json",
    success: function (response) {
      // response: Dữ liệu nhận được từ Backend API
      console.log("Response Product: ", response);
      // 2. Đưa dữ liệu nhận được lưu trữ vào mảng listPro dùng trong chương trình
      listProduct = response.content;

      // 3. Hiển thị danh sách Produ đang có trong listPro
      $("#resultAllProduct").empty();

      for (let index = 0; index < listProduct.length; index++) {
        $("#resultAllProduct").append(
          `    <tr>
          <td>${listProduct[index].id}</td>
          <td>${listProduct[index].name}</td>
          <td>${listProduct[index].price}</td>
          <td>${listProduct[index].stock_quantity}</td>
          <td>${listProduct[index].capacity}</td>
          <td>${listProduct[index].color}</td>
          <td>
            <button type="button" class="btn btn-success" onclick="editProduct(${index})">Sửa</button>
            <button type="button" class="btn btn-danger" onclick="deleteProduct(${index})">Xóa</button>
          </td>
          
        </tr>
          `
        );
      }
      var totalPages = response.totalPages;
      pagingTable(totalPages);
    },
  });
}

function pagingTable(totalPages_Param) {
  $("#pagination").empty();

  if (currentPage > 1) {
    $("#pagination").append(`
    <li class="page-item"><a href="#" class="page-link" onclick="handlePrevious()">Previous</a></li>
  `);
  }

  // Hiển thị ra các nút 1,2,3,...
  for (let index = 1; index <= totalPages_Param; index++) {
    if (index === currentPage) {
      // Active
      $("#pagination").append(`
      <li class="active"><a href="#" onclick="handleChangePage(${index})">${index}</a></li>
   `);
    } else {
      $("#pagination").append(`
       <li><a href="#" onclick="handleChangePage(${index})">${index}</a></li>
    `);
    }
  }

  if (currentPage < totalPages_Param) {
    $("#pagination").append(`
    <li class="page-item"><a href="#" class="page-link" onclick="handleNext()">Next</a></li>
  `);
  }
}

// Viết hàm xử lý khi thay đổi trang
function handleChangePage(pageParam) {
  // Kiểm tra xem trang có phải trang hiện tại không. Nếu là trang hiện tại thì không làm gì
  if (pageParam === currentPage) {
    return;
  } else {
    currentPage = pageParam;
    getListProduct();
  }
}

// Viết hàm xử lý cho nút Previous
function handlePrevious(params) {
  currentPage = currentPage - 1;
  getListProduct();
}

// Viết hàm xử lý cho nút Next
function handleNext(params) {
  currentPage = currentPage + 1;
  getListProduct();
}

function handleResetPaging() {
  currentPage = 1;
  currentSize = 5;
}

// Xoa spham
function deleteProduct(index) {
  const productId = listProduct[index].id;

  if (!confirm("Bạn có chắc muốn xóa sản phẩm này không?")) return;
  $.ajax({
    type: "DELETE",
    url: `http://localhost:8080/product/${productId}`,
    success: function () {
      alert("Xóa thành công!");
      getListProduct(); // load lại danh sách
    },
    error: function (err) {
      console.error("Lỗi khi xóa:", err);
      alert("Xóa thất bại!");
    },
  });
}

// Sua spham
function editProduct(index) {
  editIndex = index;
  const p = listProduct[index];
  $("#name").val(p.name);
  $("#price").val(p.price);
  $("#stock").val(p.stock_quantity);
  $("#capacity").val(p.capacity);
  $("#color_id").val(p.color);
  $("#modalOverlay").css("display", "flex");
}

$("#cancelBtn").click(function () {
  $("#modalOverlay").hide();
});

$("#saveBtn").click(function () {
  const updatedProduct = {
    name: $("#name").val(),
    price: $("#price").val(),
    stock_quantity: $("#stock").val(),
    capacity: $("#capacity").val(),
    color: $("#color_id").val(),
  };

  const productId = listProduct[editIndex].id;

  $.ajax({
    type: "PUT",
    url: `http://localhost:8080/product/${productId}`,
    data: JSON.stringify(updatedProduct),
    contentType: "application/json",
    success: function () {
      alert("Cập nhật thành công!");
      $("#modalOverlay").hide();
      getListProduct();
    },
    error: function (err) {
      console.error(err);
      alert("Cập nhật thất bại!");
    },
  });
});

// Them spham moi
// Mo pop-up va nhan du lieu tu form
$("#newBtnProduct").click(function (e) {
  $("#modalNewOverlay").css("display", "flex");
});

$("#cancelNewBtn").click(function () {
  $("#modalNewOverlay").hide();
});

$("#createBtn").click(function () {
  var newProduct = {
    name: $("#nameNew").val(),
    price: $("#priceNew").val(),
    stock_quantity: $("#stockNew").val(),
    capacity: $("#capacityNew").val(),
    color: $("#colorNew").val(),
  };

  $.ajax({
    type: "POST",
    url: "http://localhost:8080/product",
    data: JSON.stringify(newProduct),
    contentType: "application/json",
    success: function () {
      alert("Tạo sản phẩm thành công!");
      $("#modalNewOverlay").hide();
      getListProduct();
    },
    error: function (err) {
      console.error(err);
      alert("Tạo sản phẩm thất bại!");
    },
  });
});
