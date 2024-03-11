type LanguageData = {
    language: string[]
}

const InitialData: LanguageData = {
    language: []
}

type LanguageFormProps = LanguageData & {
    updateFields: (fields: Partial<LanguageData>) => void
}

export default function LanguageForm({
    language,
    updateFields
}: LanguageFormProps) {
    return (
        <div>
            
        </div>
    )
}