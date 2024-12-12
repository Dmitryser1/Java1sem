<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Authors List</title>
                <style>
                    body { font-family: Arial, sans-serif; margin: 20px; }
                    table { border-collapse: collapse; width: 100%; }
                    th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
                    th { background-color: #4CAF50; color: white; }
                    tr:nth-child(even) { background-color: #f2f2f2; }
                    .button {
                        background-color: #4CAF50;
                        border: none;
                        color: white;
                        padding: 10px 20px;
                        text-decoration: none;
                        display: inline-block;
                        margin: 4px 2px;
                        cursor: pointer;
                        border-radius: 4px;
                    }
                </style>
            </head>
            <body>
                <h1>Authors</h1>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Birth Date</th>
                        <th>Nationality</th>
                    </tr>
                    <xsl:apply-templates select="List/item"/>
                </table>
                <p>
                    <a href="/library/api/books?format=xml" class="button">View Books</a>
                </p>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="item">
        <tr>
            <td><xsl:value-of select="id"/></td>
            <td><xsl:value-of select="firstName"/></td>
            <td><xsl:value-of select="lastName"/></td>
            <td><xsl:value-of select="birthDate"/></td>
            <td><xsl:value-of select="nationality"/></td>
        </tr>
    </xsl:template>
</xsl:stylesheet>
