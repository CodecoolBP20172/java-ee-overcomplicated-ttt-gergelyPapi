$(document).ready(function (){

    addTicTacToeButtonFunctionality();

});

function addTicTacToeButtonFunctionality () {
    $(".square").each(function () {
        $(this).click(function(event){
            event.preventDefault();
            let parentNode = $(this).parent("[data-cell]");
            if (convertToBool (parentNode.attr("data-isfilled")) != true) {
                parentNode.attr("data-isfilled", true);
                $(this).html('<i class="fa fa-circle-o" aria-hidden="true"></i>');
                stepByPlayer(parentNode.data("cell"));
            } else {
                $(this).removeAttr("href");
                $(this).off('click');
            }
        });
    })
}

function stepByPlayer (cellNumber) {
    let data = {
        "playerSelectedCell" : cellNumber
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:60004/api/player_step",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        success: function (response) {
            console.log(response)
            stepByAi (response)

        }
    })
    checkWinningCondition ();
}

function stepByAi (response) {
    $("[data-cell]").each(function () {
        if ($(this).data("cell") == response) {
            $(this).attr("data-isfilled", true)
            $(this).children().html('<i class="fa fa-times" aria-hidden="true"></i>');
            sendAiStepInfo ($(this).data("cell"));
        }
    })
    checkWinningCondition ();
}


function sendAiStepInfo (cellNumber) {
    let data = {
        "aiSelectedCell" : cellNumber
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:60004/api/ai_step",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        success: function (response) {
            console.log(response)
        }
    })
}

function checkWinningCondition () {
    $.ajax({
        type: "GET",
        url: "http://localhost:60004/api/check_winning_condition",
        success: function (response) {
            console.log(response)
            if (response == "player") {
                alert("Player WON!")
                window.location.reload()
            }
            if (response == "ai") {
                alert("Ai WON!")
                window.location.reload()
            }
        }
    })

}

// Functions not in use!

/*function getSymbolForStep () {
    let symbol = $('<i>', {"class": "fa fa-times", "aria-hidden": "true"});
    let playerSymbol = '<i class="fa fa-circle-o" aria-hidden="true"></i>';
    return symbol
}*/

function convertToBool (string) {
    if (string == "true" || string == true) {
        return true
    }
    if (string == "false" || string == false) {
        return false
    }
}

/*
function setCurrentBoardState () {
    console.log("Board sent")
    let boardMap = [];
    console.log("Reset")
    console.log(boardMap)
    $("[data-cell]").each(function () {
        let cellNum = $(this).data("cell");
        console.log(cellNum);
        let cellBool = $(this).data("isfilled");
        console.log(cellBool);
        boardMap.push({
            cellNum : cellNum, cellBool
        });
    });
    console.log(boardMap)
    console.log(document.globalBoardState);
    document.globalBoardState = boardMap;
    boardMap = null;
    console.log(boardMap)

}*/
