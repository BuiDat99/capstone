var currentDisplayResource = [];
var resourceList = [];

function setEventInputGram() {
    $('.input-gram').change(function () {
        var value = $(this).val();
        var id = $(this).attr('resource-id-input');
        for (var r of resourceList) {
            if (r.id == id) {
                if (value == "" || value === undefined) {
                    r.gram = 0;
                    $(this).val(0);
                } else {
                    r.gram = value;
                }
                $("td[resource-id-total='" + id + "']").html((r.kcal1g * r.gram).toFixed(2));
            }
        }
        var totalKcal = 0;
        for (var r of resourceList) {
            totalKcal += r.kcal1g * r.gram
        }
        $("#total-kcal").html(totalKcal.toFixed(2));
    });
}

function drawBottomTable() {
    var totalKcal = 0;
    html = "";
    for (var i = 0; i < resourceList.length; i++) {
        totalKcal += resourceList[i].kcal1g * resourceList[i].gram
        html += '<tr>';
        html += '<td>' + (i + 1) + '</td>';
        html += '<td>' + resourceList[i].resourceName + '</td>';
        html += '<td>' + resourceList[i].kcal1g + '</td>';
        html += '<td><input class="input-gram" resource-id-input="' + resourceList[i].id + '" style="width: 100%;" type="number" value="' + resourceList[i].gram + '"></td>'
        html += '<td resource-id-total="' + resourceList[i].id + '">' + (resourceList[i].kcal1g * resourceList[i].gram).toFixed(2) + '</td>';
        html += '</tr>';
    }
    html += '<tr>';
    html += '<td class="text-center" colspan="4">Tổng số calo</td>';
    html += '<td id="total-kcal">' + totalKcal.toFixed(2) + '</td>';
    html += '</tr>';
    $("#resource-table").html(html);
    this.setEventInputGram();
}

function setEventCheckbox() {
    $(".resource-checkbox").click(function () {
        if ($(this).is(':checked')) {
            for (var e of currentDisplayResource) {
                if (e.id == $(this).val()) {
                    resourceList.push(e);
                    break;
                }
            }
        } else {
            for (var i = 0; i < resourceList.length; i++) {
                if (resourceList[i].id == $(this).val()) {
                    resourceList.splice(i, 1);
                    break;
                }
            }
        }
        // console.log('resourceList: ', resourceList);
        drawBottomTable();
    });
}

$(document).ready(function () {
    $('#dataTables-example').dataTable();
});
$("#category").change(function () {
    var categoryId = $("#category").val();
    if (categoryId == 0) {
        return;
    }
    $.ajax({
        url: document.location.origin + "/admin/resource/resourceCat/" + categoryId,
        type: 'GET',
        dataType: 'json',
    }).done(function (result) {
        var html = "";
        currentDisplayResource = [];
        for (var r of result) {
            html += '<div class="checkbox">';
            html += '<li><label><input class="resource-checkbox" type="checkbox" value="' + r.id + '" name="resource">' + r.resourceName + ' (' + r.kcal1g + ' kcal/g)' + '</label></li>';
            html += '</div>';
            r.gram = 0;
            currentDisplayResource.push(r);
        }
        $("#checkbox").html(html);
        setEventCheckbox();
    });
});
