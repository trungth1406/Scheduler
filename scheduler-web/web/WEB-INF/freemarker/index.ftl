<#compress>
<!DOCTYPE html >
<html>
<head>

</head>
<body>
    <p>If conditional :</p>
    <h1>
                        ${msg!"Default value"} <#if msg == "Hello"> there,
                                <#elseif msg == "Bye"> bye,</#if>
                        ${name} <#if name == "Trung"> Big Boi
                                <#else> Small Boi
                                </#if>
                       <#if names??>Hello this is "??" thingy, It is like if(boolean) </#if>
    </h1>
    <table>
        <thead>
        <tr>
            <td>First Column</td>
            <td>Second column</td>
            <td>Third column</td>
            <td>Fourth Column</td>
        </tr>
        </thead>
        <tbody>

            <tr>
                <#list names as item >
                <td>${item?upper_case} </td>

                </#list>
            </tr>

        <div>
            The sum:
            <#assign sum = 0>
            <#list ints as item>
                  <#assign sum = sum + item/>
                 <strong>${item}</strong>
                <#if  item_has_next> and </#if>
            </#list>

            is : ${sum}
        </div>

        </tbody>

    </table>

</body>
</html>
</#compress>