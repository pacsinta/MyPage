import { Resend } from 'resend';
import { NextRequest, NextResponse } from 'next/server';
import { EmailConfirmationTemplate } from '@/app/components /Email-template';

const resend = new Resend(process.env.RESEND_TOKEN);

export async function POST(req: NextRequest) {
    if (req.method !== 'POST') {
        return NextResponse.json({ message: 'Method not allowed' }, { status: 405 });
    }

    try {
        const body = await req.json();
        const { email, subject, emailBody } = body;

        const response = await resend.emails.send({
            to: email,
            from: 'patrik.csikos@workhard.coffee',
            subject: "Verification of: " + subject,
            react: EmailConfirmationTemplate({ email, emailBody }),
        });

        return NextResponse.json({ message: 'Email sent', response }, { status: 200 });
    } catch (error) {
        console.error('Error sending email:', error);
        return NextResponse.json({ message: 'Error sending email', error }, { status: 500 });
    }
}