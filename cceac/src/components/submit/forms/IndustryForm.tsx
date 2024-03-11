type IndustryData = {
    industry: string
}

const InitialData: IndustryData = {
    industry: "",
}

type IndustryFormProps = IndustryData & {
    updateFields: (fields: Partial<IndustryData>) => void
}

export default function IndustryForm({
    industry,
    updateFields
}: IndustryFormProps) {
    return (
        <div>
            
        </div>
    )
}