type ThemeData = {
    themes: string
}

const InitialData: ThemeData = {
    themes: ""
}

type ThemeFormProps = ThemeData & {
    updateFields: (fields: Partial<ThemeData>) => void
}

export default function ThemeForm({
    themes,
    updateFields
}: ThemeFormProps) {
    return (
        <div>
            
        </div>
    )
}