import React, { useEffect } from "react"

const Error: React.FC = () => {
    useEffect(() => {
        document.title = "Toolbox - Error | CCEAC"
    })

    return (
        <div className="error">
            <h1>Error</h1>
        </div>
    )
}

export default Error