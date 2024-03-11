type SubmitData = {
    title: string
    description: string
    contributor: string
    email: string
    source: string
    url: string
    tool_file: File | null
    thumbnail: File | null
    industry: string
    themes: string
    organizations: string
    country: string[]
    region: string
    language: string[]
    type: string
    create_time: Date
    is_review: number
}

export default function SubmitForm({
    title,
    description,
    contributor,
    email,
    source,
    url,
    tool_file,
    thumbnail,
    industry,
    themes,
    organizations,
    country,
    region,
    language,
    type,
    create_time,
    is_review,
}: SubmitData) {
    return (
        <div className="review">
            
        </div>
    )
}