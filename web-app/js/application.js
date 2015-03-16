if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}
$(function () {
    $('.list-group-item').on('click', function (e) {
        var previous = $(this).closest(".list-group").children(".active");
        previous.removeClass('active'); // previous list-item
        $(e.target).addClass('active'); // activated list-item
    });
    $('button.assign').on('click', function (e) {
        var taskId = $('.list-group-item.active').first().data('id'),
            stylistId = $(e.currentTarget).data('id');
        $.ajax({
            url: '/workflow-engine-prototype/lead/assign',
            type: 'GET',
            data: { taskId: taskId, stylistId : stylistId } ,
            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                location.reload(false);
            },
            error: function (response) {
                location.reload(false);
            }
        });
    });
    $('button.start-flow').on('click', function () {
        $.ajax({
            url: '/workflow-engine-prototype/lead/start_process',
            type: 'GET',
            success: function (response) {
                location.reload(false);
            },
            error: function (response) {
                location.reload(false);
            }
        });
    });
    $('button.call-success').on('click', function (e) {
        var taskId = $(e.currentTarget).data('taskid'),
            stylistId = $(e.currentTarget).data('stylistid');
        $.ajax({
            url: '/workflow-engine-prototype/task/finish',
            type: 'GET',
            data: { taskId: taskId, stylistId: stylistId },
            success: function (response) {
                location.href = '/workflow-engine-prototype/stylist?stylistId=' + stylistId;
            },
            error: function (response) {
                location.href = '/workflow-engine-prototype/stylist?stylistId=' + stylistId;
            }
        });
    });
    $('button.call-failed').on('click', function(e) {
        var stylistId = $(e.currentTarget).data('stylistid');
        location.href = '/workflow-engine-prototype/stylist?stylistId=' + stylistId;
    });
});