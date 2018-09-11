const baseApiPath = "http://localhost:8080/api/";

function loadUsers() {
  $.ajax({
    url: baseApiPath + "users",
    type: "GET",
    success: data => {
      const items = data.data;

      const table = document.getElementById("user-table");

      if (items && items.length) {
        $("tbody#user-table tr").remove();

        items.forEach(item => {
          const row = table.insertRow(-1);
          row.insertCell(0).innerHTML = item.id;
          row.insertCell(1).innerHTML = item.firstName;
          row.insertCell(2).innerHTML = item.lastName;
          row.insertCell(3).innerHTML = `<button onclick="deleteUser(${
            item.id
          })" class="btn btn-danger">Delete</button>&nbsp;<button onclick="editUser(${
            item.id
          })" class="btn btn-default">Edit</button>`;
        });
      }
    },
    error: error => {
      alert("request fail=" + error);
    }
  });
}

function deleteUser(userId) {
  $.ajax({
    url: baseApiPath + "users/" + userId,
    type: "DELETE",
    success: success => {
      loadUsers();
    },
    error: error => {
      alert("request fail=" + error);
    }
  });
}

function addUser() {
  const user = {};

  user.firstName = $("#first-name").val();
  user.lastName = $("#last-name").val();

  clearModalData();

  $.ajax({
    url: baseApiPath + "users",
    type: "PUT",
    contentType: "application/json",
    data: JSON.stringify(user),
    success: success => {
      loadUsers();
    },
    error: error => {
      alert("request fail=" + error);
    }
  });
}

function clearModalData() {
  $("#first-name").val("");
  $("#last-name").val("");
}

function editUser(id) {
  console.log("edit user=", id);
}
