type ToolData = {
    contributor: string
    title: string
    email: string
}

const InitialData: ToolData = {
    contributor: "",
    title: "",
    email: ""
}

type ToolDataProps = ToolData & {
    updateFields: (fields: Partial<ToolData>) => void
}

export default function ToolForm({
    contributor,
    title,
    email,
    updateFields
}: ToolDataProps) {
    return (
        <div>
            
        </div>
    )
}