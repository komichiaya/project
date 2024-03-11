type CountryData = {
    country: string[]
    region: string
}

const InitialData: CountryData = {
    country: [],
    region: ""
}

type CountryFormProps = CountryData & {
    updateFields: (fields: Partial<CountryData>) => void
}

export default function CountryForm({
    country,
    region,
    updateFields
}: CountryFormProps) {
    return (
        <div>
            
        </div>
    )
}