<form action="saveRegion.cool" method="POST">
    <input type="text" name="name"/>
    <input type="submit" value="Save"/>
</form>


<#if msg??>${msg}</#if>

<table>
    <#if regionList??>
        <#list regionList as region>
            <tr>
                <td>${region.id}</td>
                <td>${region.name}</td>
            </tr>
        </#list>
    </#if>

</table>