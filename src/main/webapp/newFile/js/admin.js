 $(document).ready(function()
    {
        var link = null;
        $('.private-n1 a').each(function()
        {
        	var path = $(this).attr('href');
        	path = path.substring(path.indexOf("/"));
        	console.log(path);
        	var lopath = location.pathname;
        	var str = lopath.split("/");
        	lopath = "/" + str[str.length - 2] + "/" +str[str.length - 1];
        	//var num = lopath.indexOf("/");
        	//var num2 = lopath.indexOf("/",num + 1);
        	//lopath = lopath.substring(num2);
     
            if (path == lopath)
            {
                link = $(this);
                return false;
            }
        });
        if (null == link) return;
        //link.parent().parent().parent().parent().find('.dropdown-fw').removeClass('open selected');
        //link.parent().parent().parent().addClass('open');
        //link.parent().addClass('active');
        link.parent().addClass('open');
    });