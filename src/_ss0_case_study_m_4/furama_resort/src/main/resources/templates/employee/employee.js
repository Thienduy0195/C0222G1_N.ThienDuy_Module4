$(document).ready(function () {

    $('#tableCustomer').on("click", ".editEmployee", function (event) {
        let a = $(this);
        let id = a.attr("href");
        $.ajax({
            type: "GET",
            url: `/api/employee/${id}`,
            success: function (data) {
                loadDataUpdate(data)
                // console.log(data);
                $('#modalEdit').modal("show");
            }
        });
        event.preventDefault();
    });

    function loadDataUpdate(data) {
        document.getElementById("id").value = data.id;
        document.getElementById("name").value = data.name
        // document.getElementById("position1").value = data.position.positionName
        // document.getElementById("division").innerHTML = data.division
        // document.getElementById("educationDegree").innerHTML = data.educationDegree;
        document.getElementById("birthDay").value = data.birthDay
        document.getElementById("idCard").value = data.idCard
        document.getElementById("salary").value = data.salary
        document.getElementById("phone").value = data.phone
        document.getElementById("email").value = data.email
        document.getElementById("address").value = data.address
    }

    $('#tableCustomer').on("click", ".deleteCustomer", function (event) {
        //lay du lieu
        let a = $(this);
        let id = a.attr("href");
        // goi ajax
        $.ajax({
            type: "GET",
            //tên API
            url: `/api/employee/${id}`,
            //CHƯA LÀM REST CONTROLLER
            success: function (data) {
                console.log(data)
                showInfoDelete(data)
            }
        });
        //chặn sự kiện mặc định của thẻ
        event.preventDefault();
    });



    function showInfoDelete(item) {
        document.getElementById("id_delete").value = item.id;
        document.getElementById("name_delete").innerText = "Do you want to delete " + item.name + "?";
        document.getElementById("email_delete").innerText = "Email: " + item.email;
    }

})

function successHandler(data) {
    debugger
    let content = '';
    for (let i = 0; i < data.length; i++) {
        content += getEmployee(data[i]);
    }
    document.getElementById('customerList').innerHTML = content;
}

function getEmployee(row) {
    return `            <tr>
                <td>${row.id}</td>
                <td>${row.name}</td>
                <td>${row.birthDay}</td>
                <td>${row.idCard}</td>
                <td>${row.salary}</td>
                <td>${row.phone}</td>
                <td>${row.email}</td>
                <td>${row.address}</td>
                <td>
                    <a id="editItem" type="button" class="btn btn-primary- editEmployee" href="${row.id}"
                       data-toggle="modal" data-target="#modalEdit">
                        <i class="fa-solid fa-pen-to-square"></i>
                    </a>
                </td>
                <td>
                    <a id="deleteItem" type="button" class="btn btn-danger deleteCustomer" href="${row.id}"
                       data-toggle="modal" data-target="#exampleModalCenter">
                        <i class="fas fa-trash"></i>
                    </a>
                </td>
            </tr>`;
}

function saveEditEmployee() {
    let id = $('#id').val();
    let name = $('#name').val();
    let position = $('#position').val();
    let division = $('#division').val();
    let educationDegree = $('#educationDegree').val();
    let birthDay = $('#birthDay').val();
    let idCard = $('#idCard').val();
    let salary = $('#salary').val();
    let phone = $('#phone').val();
    let email = $('#email').val();
    let address = $('#address').val();
    let newEmployee = {
        id: id,
        name: name,
        position:{
            positionId:position
        },
        division:{
            divisionId:division
        },
        educationDegree: {
            eduDegreeId:educationDegree
        },
        birthDay : birthDay,
        idCard:idCard,
        salary:salary,
        phone:phone,
        email:email,
        address:address
    }
    debugger
    console.log(newEmployee)
    console.log("AAA")
    // goi ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(newEmployee),
        //tên API
        url: `/api/employee/update`,
        //xử lý khi thành công
        success: function(data){
            debugger
            successHandler(data)
        }

    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}