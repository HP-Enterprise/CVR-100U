package com.cvr.test;

/**
 * Created by Teemol on 2015/11/23.
 */

/**
 * <table summary="JsonResult" class="typeSummary">
 *     <thead>
 *         <tr>
 *             <th>字段</th>
 *             <th>数据类型</th>
 *             <th>说明</th>
 *         </tr>
 *     </thead>
 *     <tbody>
 *         <tr>
 *             <td>status</td>
 *             <td>String</td>
 *             <td>返回状态码</td>
 *         </tr>
 *         <tr>
 *             <td>message</td>
 *             <td>Object</td>
 *             <td>返回数据</td>
 *         </tr>
 *     </tbody>
 * </table>
 */
public class ObjectResult {

    private String status;
    private Object message;

    public ObjectResult(String status, Object message) {
        this.status = status;
        this.message = message;
    }

    public Object toResult(String webflag){
        if(webflag != null)
            return this;
        else
            return this.getMessage();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
