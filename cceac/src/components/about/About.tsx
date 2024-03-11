import React, { useEffect } from "react"

const About: React.FC = () => {
    useEffect(() => {
        document.title = "Toolbox - About | CCEAC"
    })

    return (
        <div className="about">
            <h1>About</h1>
        </div>
    )
}

export default About