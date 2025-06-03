function sendAjax(options){
    $.ajax({
        url:options.url,
        method:options.method || 'GET',
        data:options.data || {},
        dataType : options.dataType || 'text',
        success:options.success,
        error:options.error || function (){
            alert("오류 발생");
        }
    })
}