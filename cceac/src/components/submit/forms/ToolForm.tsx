type ToolData = {
    description: string
    source: string
    url: string
    tool_file: File | null
    thumbnail: File | null
}

const InitialData: ToolData = {
    description: "",
    source: "",
    url: "",
    tool_file: null,
    thumbnail: null
}

type ToolDataProps = ToolData & {
    updateFields: (fields: Partial<ToolData>) => void
}

export default function ToolForm({
    description,
    source,
    url,
    tool_file,
    thumbnail,
    updateFields
}: ToolDataProps) {
    return (
        <div>
            
        </div>
    )
}