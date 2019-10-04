function sendStore(csrf, name, address, workTime, comment) {
    let body = {
        "name": name,
        "address": address,
        "workTime": workTime,
        "comment": comment
    };

    $.ajax({
        url: '/stores',
        contentType: 'application/json',
        type: 'post',
        headers: {
            'X-CSRF-TOKEN': csrf
        },
        dataType: 'json',
        data: JSON.stringify(body),
        success: function (response) {
            reloadTableByResponse(response);
        }
    })

}

function deleteStore(csrf, storeId) {
    let body = {
        "store": storeId

    };
    $.ajax({
        url: '/stores/delete',
        contentType: 'application/json',
        type: 'post',
        headers: {
            'X-CSRF-TOKEN': csrf
        },
        dataType: 'json',
        data: JSON.stringify(body),
        success: function (response) {
            reloadTableByResponse(response);
        }
    })
}

function reloadTableByResponse(response) {
    let newStoresListHtml = '<thead class="thread-dark">\n' +
        '    <tr>\n' +
        '       <th>ID</th>\n' +
        '      <th>NAME</th>\n' +
        '     <th>ADDRESS</th>\n' +
        '    <th>WORK TIME</th>\n' +
        '   <th>COMMENT</th>\n' +
        '  <th>COUNT</th>\n' +
        '  </tr>\n' +
        '  </thead>';
    for (let i = 0; i < response.length; i++) {
        let store = response[i];
        newStoresListHtml += '<tr>';
        newStoresListHtml += '<td>' + store["id"] + '</td>';
        newStoresListHtml += '<td>' + store["name"] + '</td>';
        newStoresListHtml += '<td>' + store["address"] + '</td>';
        newStoresListHtml += '<td>' + store["workTime"] + '</td>';
        newStoresListHtml += '<td>' + store["comment"] + '</td>';
        newStoresListHtml += '<td>' + store["count"] + '</td>';
        newStoresListHtml += '</tr>';
    }
    $("#stores-list").html(newStoresListHtml);
}
