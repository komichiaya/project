import React, { useEffect } from "react"

const Home: React.FC = () => {
    useEffect(() => {
        document.title = "Toolbox - Home | CCEAC"
    })

    return (
        <div className="home">
            <h1>Home</h1>
        </div>
    )
}

export default Home