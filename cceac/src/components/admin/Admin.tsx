import React, { useEffect } from "react"

const Admin: React.FC = () => {
    useEffect(() => {
        document.title = "Toolbox - Admin | CCEAC"
    })

    return (
        <div className="admin">
            <h1>Admin</h1>
        </div>
    )
}

export default Admin