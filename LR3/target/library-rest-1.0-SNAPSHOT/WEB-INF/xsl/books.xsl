<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Books List</title>
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
                <h1>Books</h1>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>ISBN</th>
                        <th>Publication Year</th>
                        <th>Available Copies</th>
                        <th>Author</th>
                    </tr>
                    <xsl:apply-templates select="List/item"/>
                </table>
                <p>
                    <a href="/library/api/authors?format=xml" class="button">View Authors</a>
                </p>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="item">
        <tr>
            <td><xsl:value-of select="id"/></td>
            <td><xsl:value-of select="title"/></td>
            <td><xsl:value-of select="isbn"/></td>
            <td><xsl:value-of select="publicationYear"/></td>
            <td><xsl:value-of select="availableCopies"/></td>
            <td>
                <xsl:value-of select="author/firstName"/>
                <xsl:text> </xsl:text>
                <xsl:value-of select="author/lastName"/>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>
