/**
 * 流程审批，提供名称为afterApproveTask函数，在执行完毕会调用；
 * @param taskId：任务ID；
 * @param flag：是否同意，true为同意，false为拒绝；
 * @param elementId：按钮的ID；
 * @param desc：审批备注；
 */
function approveTask(taskId, flag, elementId, desc) {
    layer.msg("系统处理中，请稍候。");
    startModal("#" + elementId);
    $.post("/process/apply", {taskIds: taskId, agree: flag, desc: desc}, function (data) {
        Ladda.stopAll();
        if (data.data == null) {
            layer.msg(data.msg);
        } else {
            layer.msg(data.data.message);
        }

        // 回调定义的函数；
        if (typeof (afterApproveTask) == "function") {
            afterApproveTask();
        }

        // 返回审批页面；
        setTimeout(function () {
            window.location.href = '/process/queryTask';
        }, 1000);
    }, "json")
}