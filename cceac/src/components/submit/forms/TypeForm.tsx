type ThemeData = {
    type: string
}

const InitialData: ThemeData = {
    type: ""
}

type ThemeFormProps = ThemeData & {
    updateFields: (fields: Partial<ThemeData>) => void
}

export default function ThemeForm({
    type,
    updateFields
}: ThemeFormProps) {
    return (
        <div>
            
        </div>
    )
}