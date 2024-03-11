import React, { useEffect } from "react"

const Search: React.FC = () => {
    useEffect(() => {
        document.title = "Toolbox - Search | CCEAC"
    })

    return (
        <div className="search">
            <h1>Search</h1>
        </div>
    )
}

export default Search