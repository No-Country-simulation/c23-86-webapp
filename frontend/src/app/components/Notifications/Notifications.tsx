"use client";

export default function Notifications() {
  return (
    <div className="w-1/4 min-h-screen bg-white dark:bg-gray-800 shadow-lg p-4">
      <h2 className="text-lg font-semibold text-primary1 dark:text-primary2">
        Notificaciones
      </h2>
      <p className="text-secondary1 dark:text-secondary2">Aquí aparecerán las notificaciones del sistema.</p>

      {/* 🔧 Esto es solo un placeholder. Luego aquí agregaremos la lista de notificaciones */}
      <div className="mt-4 p-4 border border-secondary1 rounded-lg">
        <p className="text-sm text-gray-500">No hay notificaciones por ahora.</p>
      </div>
    </div>
  );
}
