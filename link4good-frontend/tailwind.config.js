/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: ["class"],
  content: [
    './pages/**/*.{ts,tsx}',
    './components/**/*.{ts,tsx}',
    './app/**/*.{ts,tsx}',
    './src/**/*.{ts,tsx}',
  ],
  prefix: "",
  theme: {
    extend: {
      fontFamily: {
        'sans': ['Poppins', 'sans-serif'],
      }
    }
  },
  plugins: [
    require('daisyui'),
  ],
  daisyui: {
    themes: [{
      myTheme: {
        "primary": "#2839C2",
        "primary-content": "#ffffff",
        "secondary": "#08247F",
        "accent": "#43B1FB",
        "neutral": "#121308",
        "base-100": "#fff8f4",
        "base-content": "#ffffff",
        "info": "#87DCF3",
        "success": "#328555",
        "warning": "#F69D26",
        "error": "#F02C2C",
      }
    }]
  }
}
