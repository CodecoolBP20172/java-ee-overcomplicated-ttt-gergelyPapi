$(document).ready(function (){

    addTicTacToButtonFunctionality();

    function addTicTacToButtonFunctionality () {
        console.log("This run");
        $(".square").each(function (event) {
            console.log($(this));
            $(this).on("click", function( event) {
                console.log(event);
                event.preventDefault();
                let targetAnchor = event.target
                console.log(event.target);
                targetAnchor.append($('<i>', {"class": "fa fa-times", "aria-hidden": "true"}));
                $(this).off('click');
                //step();
            });
        })
    }

    function step () {
        $.ajax({
            type: "POST",
            url: "/api/remove_food_from_order",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                buildFoodContainer(response, orderId);
                addRemoveButtonFunctionality();
            }
        })
    }


});