
/**
 * 自动加载规则流水信息
 */
 
window.onload = function () {
 
    $.ajax({
 
        type: 'post',
        url: "querylist",
        contentType: "application/json;cherset=utf-8",
        dataType: "json",
        success: function (data)
                $('.table_node').empty()
                //取出后端传过来的list值
                var chargeRuleLogs = data.data
                //对list值进行便利
    $.each(chargeRuleLogs, function (index, n) {
 
          var rowTr = document.createElement('tr')
          //找到html的tr节点
 
          rowTr.className = "tr_node"
               var child = "<td>" + chargeRuleLogs[index].id +  "</td>"
               + "<td>" + chargeRuleLogs[index].name + "</td>"
               + "<td>" + chargeRuleLogs[index].age + "</td>"
               + "<td>"+chargeRuleLogs[index].sex + "</td>"
 
                //将要展示的信息写入页面
                rowTr.innerHTML = child
                //将信息追加
                $(".table_node").append(rowTr)
                    });
              }        
    });
}