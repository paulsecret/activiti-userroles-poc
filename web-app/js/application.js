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
        console.log('taskId:', taskId, 'stylistId:', stylistId);
    })
});